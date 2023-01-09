create database QLCB;
use QLCB;

create table tbCanBo(
	SoTK int primary key not null,
	Hoten nvarchar(30),
	GT nvarchar(10),
	DiaChi nvarchar(30),
	Luong float
);

insert into tbCanBo
values 
(111111111, N'Nguyễn Văn A', N'nam', N'Hà Nam', 234.6),
(222222222, N'Nguyễn Thị B', N'nữ', N'Hà Nội', 5999.8),
(333333333, N'Nguyễn Khánh C', N'nam', N'Hải Phòng', 3000)

drop table tbCanBo

select * from tbCanBo