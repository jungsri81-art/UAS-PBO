public class Belanja {
    private int id;
    private String nama;
    private int jumlah;
    private int harga;
    private String tanggal;

    public Belanja(int id, String nama, int jumlah, int harga, String tanggal) {
        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
        this.tanggal = tanggal;
    }

    // Getter & Setter
    public int getId() { return id; }
    public String getNama() { return nama; }
    public int getJumlah() { return jumlah; }
    public int getHarga() { return harga; }
    public String getTanggal() { return tanggal; }

    public void setId(int id) { this.id = id; }
    public void setNama(String nama) { this.nama = nama; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }
    public void setHarga(int harga) { this.harga = harga; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }
}