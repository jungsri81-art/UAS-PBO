CREATE DATABASE IF NOT EXISTS db_belanja;
USE db_belanja;

CREATE TABLE belanja (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama_barang VARCHAR(100),
    jumlah INT,
    harga DOUBLE
);