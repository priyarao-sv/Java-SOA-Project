create database login;
use login;
create table Login(cust_id int not null primary key auto_increment, email varchar(255), password varchar(255), verified_status varchar(20));