-- Buat database
CREATE DATABASE db_belanja;

-- Gunakan database
USE db_belanja;

-- Buat tabel belanja
CREATE TABLE belanja (
    id INT AUTO_INCREMENT PRIMARY KEY,   -- ID unik otomatis
    nama_barang VARCHAR(50) NOT NULL,    -- Nama barang
    jumlah INT NOT NULL,                 -- Jumlah barang
    harga INT NOT NULL,                  -- Harga bulat (integer)
    tanggal DATE NOT NULL                -- Tanggal pembelian (format YYYY-MM-DD)
);

INSERT INTO belanja (nama_barang, jumlah, harga, tanggal)
VALUES 
('Buku Tulis', 2, 5000, '2026-01-16'),
('Pulpen', 3, 3000, '2026-01-16'),
('Snack', 5, 2000, '2026-01-17'),
('Sayur', 5, 2000, '2026-01-20');

SELECT * FROM belanja;
SELECT * FROM belanja WHERE tanggal = '2026-01-16';
DELETE FROM belanja WHERE id = 3;
UPDATE belanja 
SET harga = 4000 
WHERE id = 2;

