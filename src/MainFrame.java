

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private JTextField txtNama, txtJumlah, txtHarga, txtTanggal;
    private JTable table;
    private DefaultTableModel model;
    private JLabel lblStatus;

    public MainFrame() {
        setTitle("Catatan Belanja Harian");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Font poppinsFont = new Font("Poppins", Font.PLAIN, 14);
        Color bgColor = new Color(0, 0, 128);       // navy
        Color btnColor = new Color(30, 144, 255);   // biru cerah

        JPanel panelMain = new JPanel(new BorderLayout());
        panelMain.setBackground(bgColor);
        setContentPane(panelMain);

        // Input panel dengan GridBagLayout
        JPanel panelInput = new JPanel(new GridBagLayout());
        panelInput.setBackground(bgColor);
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtNama = new JTextField(20); 
        txtNama.setFont(poppinsFont);
        txtNama.setHorizontalAlignment(JTextField.LEFT);

        txtJumlah = new JTextField(5); 
        txtJumlah.setFont(poppinsFont);
        txtJumlah.setHorizontalAlignment(JTextField.LEFT);

        txtHarga = new JTextField(10); 
        txtHarga.setFont(poppinsFont);
        txtHarga.setHorizontalAlignment(JTextField.LEFT);

        txtTanggal = new JTextField(10); 
        txtTanggal.setFont(poppinsFont);
        txtTanggal.setHorizontalAlignment(JTextField.LEFT);

        gbc.gridx = 0; gbc.gridy = 0;
        panelInput.add(createLabel("Nama Barang", poppinsFont), gbc);
        gbc.gridx = 1;
        panelInput.add(txtNama, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panelInput.add(createLabel("Jumlah", poppinsFont), gbc);
        gbc.gridx = 1;
        panelInput.add(txtJumlah, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panelInput.add(createLabel("Harga", poppinsFont), gbc);
        gbc.gridx = 1;
        panelInput.add(txtHarga, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panelInput.add(createLabel("Tanggal (YYYY-MM-DD)", poppinsFont), gbc);
        gbc.gridx = 1;
        panelInput.add(txtTanggal, gbc);

        // Tombol
        JButton btnTambah = createButton("➕ Tambah", poppinsFont, btnColor);
        JButton btnUpdate = createButton("✏️ Update", poppinsFont, btnColor);
        JButton btnHapus = createButton("🗑️ Hapus", poppinsFont, btnColor);

        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTombol.setBackground(bgColor);
        panelTombol.add(btnTambah);
        panelTombol.add(btnUpdate);
        panelTombol.add(btnHapus);
        panelInput.add(panelTombol, gbc);

        // Tabel
        model = new DefaultTableModel(new String[]{"ID", "Nama", "Jumlah", "Harga", "Tanggal"}, 0);
        table = new JTable(model);
        table.setFont(poppinsFont);
        table.setForeground(Color.BLACK);
        table.setRowHeight(22);
        table.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table);

        // Status bar
        lblStatus = new JLabel("Total catatan: 0");
        lblStatus.setFont(poppinsFont);
        lblStatus.setForeground(Color.WHITE);
        lblStatus.setHorizontalAlignment(SwingConstants.LEFT);

        panelMain.add(panelInput, BorderLayout.NORTH);
        panelMain.add(scrollPane, BorderLayout.CENTER);
        panelMain.add(lblStatus, BorderLayout.SOUTH);

        loadData();

        // Event klik tabel
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    txtNama.setText(model.getValueAt(row, 1).toString());
                    txtJumlah.setText(model.getValueAt(row, 2).toString());
                    txtHarga.setText(model.getValueAt(row, 3).toString());
                    txtTanggal.setText(model.getValueAt(row, 4).toString());
                }
            }
        });

        // Tambah
        btnTambah.addActionListener(e -> {
            try {
                Belanja b = new Belanja(0,
                        txtNama.getText(),
                        Integer.parseInt(txtJumlah.getText()),
                        Integer.parseInt(txtHarga.getText()),
                        txtTanggal.getText());
                int newId = BelanjaDAO.insertBelanja(b);
                model.addRow(new Object[]{newId, b.getNama(), b.getJumlah(), b.getHarga(), b.getTanggal()});
                lblStatus.setText("Total catatan: " + model.getRowCount());
                clearForm();
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Input tidak valid!");
            }
        });

        // Update
        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                try {
                    int id = (int) model.getValueAt(row, 0);
                    Belanja b = new Belanja(id,
                            txtNama.getText(),
                            Integer.parseInt(txtJumlah.getText()),
                            Integer.parseInt(txtHarga.getText()),
                            txtTanggal.getText());
                    BelanjaDAO.updateBelanja(b);
                    model.setValueAt(b.getNama(), row, 1);
                    model.setValueAt(b.getJumlah(), row, 2);
                    model.setValueAt(b.getHarga(), row, 3);
                    model.setValueAt(b.getTanggal(), row, 4);
                    clearForm();
                    JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Input tidak valid!");
                }
            }
        });

        // Hapus
        btnHapus.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                int id = (int) model.getValueAt(row, 0);
                BelanjaDAO.deleteBelanja(id);
                model.removeRow(row);
                lblStatus.setText("Total catatan: " + model.getRowCount());
                clearForm();
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            }
        });
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text, SwingConstants.LEFT);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        return label;
    }

    private JButton createButton(String text, Font font, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    private void loadData() {
        model.setRowCount(0);
        List<Belanja> list = BelanjaDAO.getAllBelanja();
        for (Belanja b : list) {
            model.addRow(new Object[]{b.getId(), b.getNama(), b.getJumlah(), b.getHarga(), b.getTanggal()});
        }
        lblStatus.setText("Total catatan: " + list.size());
    }

    private void clearForm() {
        txtNama.setText("");
        txtJumlah.setText("");
        txtHarga.setText("");
        txtTanggal.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}