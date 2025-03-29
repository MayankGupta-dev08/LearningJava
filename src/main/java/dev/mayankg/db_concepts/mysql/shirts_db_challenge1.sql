# connecting to the mysql db - jdbc:mysql://localhost:3306/
mysql -u root -p
##or
mysql -u root -pmy_password

show databases;
create database shirts_db;
use shirts_db;

show tables;
create table shirts(
shirts_id int not null primary key auto_increment,
article varchar(15) not null,
color varchar(10) not null,
shirt_size varchar(3) not null default 'm',
last_worn int default 0
);
desc shirts;

insert into shirts (article, color, shirt_size, last_worn)
values
('t-shirt', 'white', 's', 10),
('t-shirt', 'green', 's', 200),
('polo shirt', 'black', 'm', 10),
('tank top', 'blue', 's', 50),
('t-shirt', 'pink', 's', 0),
('polo shirt', 'red', 'm', 5),
('tank top', 'white', 's', 200),
('tank top', 'blue', 'm', 15);

select * from shirts;
insert into shirts(article, color, shirt_size, last_worn) 
	values('polo shirt', 'purple', 'm', 50);
select article,color,shirt_size,last_worn from shirts;

update shirts set shirt_size='L' where article='polo shirt';
update shirts set last_worn=0 where last_worn=15;
update shirts set color='off white', shirt_size='XS' where color='white';
delete from shirts where last_worn=200;
delete from shirts where article='tank top';
delete from shirts;
drop table shirts;
show tables;
