create database DLKH;
use DLKH;

create table tbKhachHang(
	SoTK int primary key not null,
	HoTen nvarchar(30),
	GT nvarchar(10),
	DiaChi nvarchar(30),
	SoDu float
);

insert into tbKhachHang
values
(111111, N'Nguyễn Văn A', N'nam', N'Hà Nội', 20038.5),
(222222, N'Bùi Thanh B', N'nam', N'Hà Nội', 1788393),
(333333, N'Phạm Huyền C', N'nữ', N'Nam Định', 90038.5555),
(444444, N'Nguyễn Thị D', N'nữ', N'Hải Phòng', 37669.788)

select *from tbKhachHang

delete from tbKhachHang
where DiaChi = N'Hà Nội' and GT = N'nam'