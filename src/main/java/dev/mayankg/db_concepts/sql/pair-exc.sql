-- CREATING AND USING 'temp' DB
CREATE DATABASE IF NOT EXISTS temp;
SHOW DATABASES;
USE temp;

-- Dropping the table if they already exist
DROP TABLE IF EXISTS pairs;

-- TABLE SCHEMA FOR 'pairs'
CREATE TABLE pairs (
    A int,
    B int
);

-- Inserting values into temp.pairs
INSERT INTO pairs (A,B) 
	VALUES (1,2), (2,4), (2,1), (3,2), (4,2), (5,6), (6,5), (7,8);

-- Show table 'pairs'
SELECT * FROM pairs;

## remove reversed pairs 

-- METHOD 1: JOINS


-- METHOD 2: CO-RELATED SUBQUERY 

