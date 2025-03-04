# SQL Notes

## Type of SQL Language
1. DDL (Data Definition Language)
2. DML (Data Manipulation Language)
3. DCL (Data Control Language)
4. TCL (Transaction Control Language)

## Table of Contents
1. Show Databases
2. Create Database
3. Drop Database
4. Use Database
5. Show Tables
6. Create Table
7. Drop Table
8. Truncate Table
9. Alter Table
10. Insert Data
11. Select Data
12. Update Data
13. Delete Data
14. Constraints
15. Joins
16. Indexes
17. Views
18. Stored Procedures
19. Functions
20. Triggers
21. Transactions
22. Locks
23. Cursors
24. Temporary Tables
25. User Privileges
26. Backup and Restore

## SQL Commands

### Related to Database

#### Show Databases
```sql
SHOW DATABASES;
```

#### Create Database
```sql
CREATE DATABASE <database_name>;
```

#### Drop Database
```sql
DROP DATABASE <database_name>;
```

#### Use Database
```sql
USE <database_name>;
```

### Related to Tables

#### Show Tables
```sql
SHOW TABLES;
```

#### Create Table
```sql
CREATE TABLE <table_name> (
    column1 datatype,
    column2 datatype,
    ...
);
```
```sql
CREATE TABLE <table_name> (
    id INT NOT NULL PRIMARY KEY,
    column1 datatype NOT NULL DEFAULT value,
    column2 datatype,
    ...
);
```
```sql
CREATE TABLE <table_name> (
    id INT NOT NULL,
    column1 datatype NOT NULL DEFAULT value,
    column2 datatype,
    PRIMARY KEY (id)
    ...
);
```
```sql
CREATE TABLE <table_name> (
    id INT NOT NULL AUTO_INCREMENT,
    column1 datatype NOT NULL DEFAULT value,
    column2 datatype,
    PRIMARY KEY (id)
    ...
);
```

#### Show columns of a Table
```sql
SHOW COLUMNS FROM <table_name>;
```
```sql
DESC <table_name>;
```

#### Drop Table
```sql
DROP TABLE <table_name>;
```

#### Truncate Table
```sql
TRUNCATE TABLE <table_name>;
```

#### Alter Table
```sql
ALTER TABLE <table_name>
ADD column_name datatype;
```

### Related to Data

#### Insert Data
```sql
INSERT INTO <table_name> (column1, column2, ...)
VALUES 
    (value1, value2, ...),
    (value11, value22, ...),
    ...;
```

#### Select Data
```sql
SELECT column1, column2, ...
FROM <table_name>
WHERE condition;
```

#### Update Data
```sql
UPDATE <table_name>
SET column1 = value1, column2 = value2, ...
WHERE condition;
```