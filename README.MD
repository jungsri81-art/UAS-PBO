# Aplikasi Catatan Belanja Harian 🛒

Aplikasi desktop sederhana untuk mencatat belanja harian berbasis **Java Swing** dan **MySQL/MariaDB**.  
Fitur utama mencakup manajemen data belanja (CRUD: Create, Read, Update, Delete), tampilan GUI interaktif, serta status bar untuk memantau jumlah catatan.

---

## 👥 Daftar Anggota Kelompok

1. Anak Agung Istri Sri Wangi Nariswari — NIM: 240030378  
2. Habibbah Alya Nabila — NIM: 240030444  
3. Ni Made Pradnyan Ari Laksita — NIM: 240030366  
4. Komang Prima Saputra Bendika — NIM: 240030414  

---

## ⚙️ Lingkungan Pengembangan

- Java (Swing GUI)
- MySQL / MariaDB
- JDBC (MySQL Connector/J)
- IDE: NetBeans / VS Code
- Git & GitHub
- Visual Studio Code

---

## ✨ Fitur Utama

### 1. Manajemen Data (CRUD)
- **Create** → Tambah catatan belanja baru (nama barang, jumlah, harga, tanggal)
- **Read** → Menampilkan semua catatan belanja dalam tabel
- **Update** → Mengubah data belanja yang sudah ada
- **Delete** → Menghapus catatan belanja dari database

### 2. Komponen GUI
- `JFrame` → Frame utama aplikasi
- `JPanel` → Panel input & tabel
- `JLabel` → Label form
- `JTextField` → Input data
- `JButton` → Tombol aksi (Tambah, Update, Hapus)
- `JTable` → Menampilkan data belanja
- `JScrollPane` → Scroll tabel
- Status bar → Menampilkan jumlah total catatan

### 3. Antarmuka Aplikasi
- Form input data belanja
- Form edit data
- Fitur hapus data
- Tabel menampilkan data jamak dan tunggal
- Status bar otomatis update jumlah catatan

---

## 📂 Struktur Project
UAS-PBO/
├── Main.java
├── MainFrame.java
├── Belanja.java
├── BelanjaDAO.java
├── DatabaseConnection.java
├── db_belanja.sql
└── lib/
    └── mysql-connector-j-8.0.xx.jar
└── README.MD

## 📸 Tampilan Aplikasi
![alt text](<Screenshot 2026-01-21 152144.png>)
### ✅ Pop-up Tambah Data
![alt text](<Screenshot 2026-01-21 145859.png>)
### ✅ Pop-up Update Data
![alt text](<Screenshot 2026-01-21 153707.png>)
### ✅ Pop-up Hapus Data
![alt text](<Screenshot 2026-01-21 155245.png>)
