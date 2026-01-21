import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BelanjaDAO {
    public static List<Belanja> getAllBelanja() {
        List<Belanja> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM belanja")) {

            while (rs.next()) {
                Belanja b = new Belanja(
                    rs.getInt("id"),
                    rs.getString("nama_barang"),
                    rs.getInt("jumlah"),
                    rs.getInt("harga"),
                    rs.getString("tanggal")
                );
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int insertBelanja(Belanja b) {
        int newId = -1;
        String sql = "INSERT INTO belanja(nama_barang, jumlah, harga, tanggal) VALUES(?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, b.getNama());
            ps.setInt(2, b.getJumlah());
            ps.setInt(3, b.getHarga());
            ps.setString(4, b.getTanggal());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) newId = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newId;
    }

    public static void updateBelanja(Belanja b) {
        String sql = "UPDATE belanja SET nama_barang=?, jumlah=?, harga=?, tanggal=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getNama());
            ps.setInt(2, b.getJumlah());
            ps.setInt(3, b.getHarga());
            ps.setString(4, b.getTanggal());
            ps.setInt(5, b.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBelanja(int id) {
        String sql = "DELETE FROM belanja WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}