create database DLSach;
use DLSach;

create table tbSach(
	MaS int not null primary key,
	TenS nvarchar(30),
	NamXB int,
	GiaB float
);

insert into tbSach 
values 
(111, N'Toán', 2019, 23.8),
(222, N'Văn', 2020, 20),
(333, N'Hóa', 2021, 19.3),
(444, N'Lý', 2019, 43.8)

select *from tbSach
where MaS = 111 and NamXB = 2020

delete from tbSach
where NamXB = 2019


UPDATE tbSach
SET MaS = 333, TenS = N'fff', NamXB = 2011, GiaB = 23.5 where MaS = 111
