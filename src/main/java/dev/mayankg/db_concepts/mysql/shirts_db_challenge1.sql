-- connecting to the mysql db - jdbc:mysql://localhost:3306/
mysql -u root -p
--or
mysql -u root -pmy_password

SHOW DATABASES;
CREATE DATABASE shirts_db;
USE shirts_db;

SHOW TABLES;
CREATE TABLE shirts (
  shirts_id    INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  article      VARCHAR(15)  NOT NULL,
  color        VARCHAR(10)  NOT NULL,
  shirt_size   VARCHAR(3)   NOT NULL DEFAULT 'M',
  last_worn    INT          DEFAULT 0
);
DESC shirts;

INSERT INTO shirts (article, color, shirt_size, last_worn)
VALUES
  ('t-shirt', 'white', 'S', 10),
  ('t-shirt', 'green', 'S', 200),
  ('polo shirt', 'black', 'M', 10),
  ('tank top', 'blue', 'S', 50),
  ('t-shirt', 'pink', 'S', 0),
  ('polo shirt', 'red', 'M', 5),
  ('tank top', 'white', 'S', 200),
  ('tank top', 'blue', 'M', 15);

SELECT * FROM shirts;
insert into shirts(article, color, shirt_size, last_worn) 
	values('polo shirt', 'purple', 'M', 50);
select article,color,shirt_size,last_worn from shirts;

update shirts set shirt_size='L' where article='polo shirt';
update shirts set last_worn=0 where last_worn=15;
update shirts set color='off white', shirt_size='XS' where color='white';
delete from shirts where last_worn=200;
delete from shirts where article='tank top';
delete from shirts;
drop table shirts;
show tables;
