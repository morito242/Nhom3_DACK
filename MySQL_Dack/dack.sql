create database minigame;

use minigame;

create table loginacc
(
	username varchar(100),
    pass varchar(100),
    primary key (username)
);

create table accMark
(
	id int auto_increment,
    name varchar(100),
	mark int default 0,
    primary key (id),
    foreign key (name) references loginacc(username)
);

create table category
(
	id int auto_increment,
    catename varchar(100),
    
    primary key (id)
);

create table quesandans
(
	id int auto_increment,
    ques varchar(500),
    ans varchar(500),
	idcate int,
    
    primary key (id),
    foreign key (idcate) references category (id)
);

select * from accMark;
select * from loginacc;
select * from category;
select * from quesandans;

insert into category (catename) values ('Mathematics'), ('Great Puzzles');
insert into quesandans (ques, ans, idcate) 
values 	('Matt là người chạy nhanh thứ 50 và cũng là người chạy chậm thứ 50 trong cuộc thi ở trường. Giả sử không có hai người nào chạy cùng tốc độ, tổng cộng có bao nhiêu học sinh ở trường Matt tham gia chạy?','99',1);
update accMark set mark = 0 where name = 'admin';


