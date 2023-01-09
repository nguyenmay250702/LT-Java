create database DLTS;
use DLTS;

create table tbThisinh(
	SoBD int not null primary key,
	Hoten nvarchar(30),
	GT nvarchar(10),
	NganhH nvarchar(30),
	TongD float
);

insert into tbThisinh
values 
(111, N'Nguyễn Thị A', N'nữ', N'Kỹ thuật ô tô', 23.5),
(222, N'Nguyễn Văn B', N'nam', N'Hệ thống thông tin', 10),
(333, N'Nguyễn Thị A', N'nữ', N'Công trình biển', 49.5),
(444, N'Nguyễn Thị B', N'nữ', N'Công trình biển', 34.5)


