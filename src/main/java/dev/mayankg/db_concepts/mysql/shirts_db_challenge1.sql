-- Connecting to the MySQL database
-- How do you connect to a MySQL database from the terminal?
mysql -u root -p
-- or
mysql -u root -pmy_password

-- Show all databases available in the MySQL server
-- How do you list all existing databases?
SHOW DATABASES;

-- Create a new database named 'shirts_db'
-- How can you create a new database in MySQL?
CREATE DATABASE shirts_db;

-- Select the 'shirts_db' database to use
-- How do you switch to a specific database before executing queries?
USE shirts_db;

-- Show all tables in the currently selected database
-- How do you list all tables in a database?
SHOW TABLES;

-- Create a 'shirts' table with specific columns and constraints
-- How do you create a table with an auto-increment primary key and default values?
CREATE TABLE shirts (
  shirts_id    INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  article      VARCHAR(15)  NOT NULL,
  color        VARCHAR(10)  NOT NULL,
  shirt_size   VARCHAR(3)   NOT NULL DEFAULT 'M',
  last_worn    INT          DEFAULT 0
);

-- Show the structure of the 'shirts' table
-- How do you check the schema (column details) of a table?
DESC shirts;

-- Insert multiple records into the 'shirts' table
-- How do you insert multiple rows into a table at once?
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

-- Retrieve all records from the 'shirts' table
-- How do you fetch all the records from a table?
SELECT * FROM shirts;

-- Insert a single record into the 'shirts' table
-- How do you insert a single row into a table?
INSERT INTO shirts(article, color, shirt_size, last_worn)
VALUES ('polo shirt', 'purple', 'M', 50);

-- Retrieve specific columns from the 'shirts' table
-- How do you fetch only specific columns from a table?
SELECT article, color, shirt_size, last_worn FROM shirts;

-- Update shirt_size for all 'polo shirt' records
-- How do you update values of a specific column based on a condition?
UPDATE shirts SET shirt_size='L' WHERE article='polo shirt';

-- Set last_worn to 0 where it was previously 15
-- How do you modify records that match a certain condition?
UPDATE shirts SET last_worn=0 WHERE last_worn=15;

-- Change color and size for records where color is 'white'
-- How do you update multiple columns at once?
UPDATE shirts SET color='off white', shirt_size='XS' WHERE color='white';

-- Delete records where last_worn is 200
-- How do you delete specific records from a table?
DELETE FROM shirts WHERE last_worn=200;

-- Delete all records where article is 'tank top'
-- How do you delete rows that match a specific condition?
DELETE FROM shirts WHERE article='tank top';

-- Delete all records from the table but keep the structure
-- How do you delete all data from a table without dropping it?
DELETE FROM shirts;

-- Drop the 'shirts' table permanently
-- How do you completely remove a table from the database?
DROP TABLE shirts;

-- Show all tables in the current database after deletion
-- How do you check if any tables exist in a database?
SHOW TABLES;
