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


