create database dtRectangle;
use dtRectangle;

create table tbRectangle(
	width float,
	length float,
	color nvarchar(20),
	area float,
	perimeter float,
	filled bit
);

insert into tbRectangle
values
(2,5,'Red', 10, 14, 1),
(3,5,'gree', 15, 19, 1),
(5,8,'Blue', 40, 21, 1),
(1,3,null, 3, 8, 0)