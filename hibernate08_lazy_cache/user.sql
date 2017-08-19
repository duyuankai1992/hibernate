CREATE DATABASE java1702hibernate;
use java1702hibernate;
CREATE TABLE t_user(
	id int(4) primary key auto_increment,
	username varchar(20),
	password varchar(20),
	name varchar(20)
);