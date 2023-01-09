create database DLSach;
use DLSach;

create table tbSach(
	MaS char(20),
	TenS nvarchar(30),
	NhaXB nvarchar(30),
	NamXB int,
	GiaB float
);

insert into tbSach
values
('MS01', N'Nguyễn Văn A', N'Kim Đồng', 2002, 43.6),
('MS02', N'Nguyễn Văn B', N'Giáo Dục', 2023, 173.6),
('MS03', N'Nguyễn Thị C', N'Thanh Niên', 2012, 87)

drop table tbSach

select *
from tbSach
where NhaXB = N'Thanh Niên' and GiaB = 87


