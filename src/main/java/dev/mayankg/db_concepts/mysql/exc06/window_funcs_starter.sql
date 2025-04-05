-- SELECT CURRENT DATABASE
SELECT DATABASE();

-- SHOW ALL DATABASES
SHOW DATABASES;

-- CREATE AND SELECT DATABASE
CREATE DATABASE win_funcs;
USE win_funcs;

-- SHOW TABLES IN CURRENT DATABASE
SHOW TABLES;

-- CREATE TABLE TO STORE EMPLOYEE DATA
CREATE TABLE employees (
    emp_no INT PRIMARY KEY AUTO_INCREMENT,
    department VARCHAR(20),
    salary INT
);

-- INSERT SAMPLE DATA INTO employees TABLE
INSERT INTO employees (department, salary) VALUES
    ('engineering', 80000),
    ('engineering', 69000),
    ('engineering', 70000),
    ('engineering', 103000),
    ('engineering', 67000),
    ('engineering', 89000),
    ('engineering', 91000),
    ('sales', 59000),
    ('sales', 70000),
    ('sales', 159000),
    ('sales', 72000),
    ('sales', 60000),
    ('sales', 61000),
    ('sales', 61000),
    ('customer service', 38000),
    ('customer service', 45000),
    ('customer service', 61000),
    ('customer service', 40000),
    ('customer service', 31000),
    ('customer service', 56000),
    ('customer service', 55000);

-- VIEW ALL RECORDS
SELECT * FROM employees;
