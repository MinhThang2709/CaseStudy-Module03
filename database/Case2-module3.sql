create database Winz_banking;
use Winz_banking;
drop database Winz_banking;

-- Tạo bảng nguoi_dung (user)
CREATE TABLE nguoi_dung (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ten_day_du VARCHAR(255) NOT NULL,
    ngay_sinh DATE,
    gioi_tinh VARCHAR(10),
    dia_chi VARCHAR(255),
    so_dien_thoai VARCHAR(20),
    email VARCHAR(255) NOT NULL UNIQUE,
    mat_khau VARCHAR(255) NOT NULL
);

-- Tạo bảng chi_nhanh_ngan_hang (branch)
CREATE TABLE chi_nhanh_ngan_hang (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ten_chi_nhanh VARCHAR(255),
    dia_chi_chi_nhanh VARCHAR(255),
    so_dien_thoai_chi_nhanh VARCHAR(20)
);

-- Tạo bảng nhan_vien (employee)
CREATE TABLE nhan_vien (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ten_day_du VARCHAR(255),
    ngay_sinh DATE,
    gioi_tinh VARCHAR(10),
    chuc_vu VARCHAR(255),
    phong_ban VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    so_dien_thoai VARCHAR(20),
    dia_chi VARCHAR(255),
    id_chi_nhanh INT, -- Liên kết với chi_nhanh_ngan_hang
    FOREIGN KEY (id_chi_nhanh) REFERENCES chi_nhanh_ngan_hang(id)
);

-- Tạo bảng khach_hang (customer)
CREATE TABLE khach_hang (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_nguoi_dung INT, -- Liên kết với nguoi_dung
    so_du_tai_khoan DOUBLE,
    so_tai_khoan VARCHAR(20) UNIQUE,
    FOREIGN KEY (id_nguoi_dung) REFERENCES nguoi_dung(id)
);

-- Tạo bảng tai_khoan (account)
CREATE TABLE tai_khoan (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_nguoi_dung INT, -- Liên kết với nguoi_dung
    so_tai_khoan VARCHAR(20) UNIQUE,
    loai_tai_khoan VARCHAR(255),
    so_du_tai_khoan DOUBLE,
    ngay_mo_tai_khoan DATE,
    ky_han_tai_khoan VARCHAR(255),
    id_chi_nhanh INT, -- Liên kết với chi_nhanh_ngan_hang
    FOREIGN KEY (id_nguoi_dung) REFERENCES nguoi_dung(id),
    FOREIGN KEY (id_chi_nhanh) REFERENCES chi_nhanh_ngan_hang(id)
);

-- Tạo bảng loai_giao_dich (transaction_type)
CREATE TABLE loai_giao_dich (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ten_loai_giao_dich VARCHAR(255)
);

-- Tạo bảng giao_dich (transaction)
CREATE TABLE giao_dich (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_tai_khoan_nguoi_gui INT, -- Liên kết với tai_khoan (nguoi_gui)
    id_tai_khoan_nguoi_nhan INT, -- Liên kết với tai_khoan (nguoi_nhan)
    so_tien DOUBLE,
    id_loai_giao_dich INT, -- Liên kết với loai_giao_dich
    so_du_sau_giao_dich DOUBLE,
    thoi_gian_giao_dich TIMESTAMP,
    dia_chi VARCHAR(255),
    FOREIGN KEY (id_tai_khoan_nguoi_gui) REFERENCES tai_khoan(id),
    FOREIGN KEY (id_tai_khoan_nguoi_nhan) REFERENCES tai_khoan(id),
    FOREIGN KEY (id_loai_giao_dich) REFERENCES loai_giao_dich(id)
);

-- Tạo bảng lich_su_dang_nhap (login_history)
CREATE TABLE lich_su_dang_nhap (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_nguoi_dung INT, -- Liên kết với nguoi_dung
    thoi_gian_dang_nhap TIMESTAMP,
    FOREIGN KEY (id_nguoi_dung) REFERENCES nguoi_dung(id)
);

-- Tạo bảng thong_bao (notifications)
CREATE TABLE thong_bao (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_nguoi_dung INT, -- Liên kết với nguoi_dung
    noi_dung TEXT,
    thoi_gian_thong_bao TIMESTAMP,
    FOREIGN KEY (id_nguoi_dung) REFERENCES nguoi_dung(id)
);

-- Tạo bảng phi_dich_vu (service_fees)
CREATE TABLE phi_dich_vu (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_loai_giao_dich INT, -- Liên kết với loai_giao_dich
    so_phi_dich_vu DOUBLE,
    FOREIGN KEY (id_loai_giao_dich) REFERENCES loai_giao_dich(id)
);

-- Tạo bảng ky_han (term_deposit)
CREATE TABLE ky_han (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_khach_hang INT, -- Liên kết với khach_hang
    so_tien_ky_han DOUBLE,
    lai_suat DOUBLE,
    ngay_bat_dau_ky_han DATE,
    ngay_ket_thuc_ky_han DATE,
    FOREIGN KEY (id_khach_hang) REFERENCES khach_hang(id)
);


