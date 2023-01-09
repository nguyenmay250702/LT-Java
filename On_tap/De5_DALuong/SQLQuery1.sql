create database DLLuong;
use DLLuong;

create table tbNhanvien(
	MaNV int not null primary key,
	Hoten nvarchar(30),
	Diachi nvarchar(30),
	Luong float
);

insert into tbNhanvien
values 
(111, N'Nguyễn Thị A', N'Hà Nội', 23.45),
(222, N'Nguyễn Thị B', N'Nam Định', 389),
(333, N'Nguyễn Thị C', N'Hải Phòng', 456.45)

UPDATE tbNhanvien
SET MaNV = 444, Hoten = N'rrr', Diachi = N'rrrr', Luong = 34
