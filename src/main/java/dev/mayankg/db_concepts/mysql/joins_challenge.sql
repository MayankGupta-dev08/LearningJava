-- SHOW ALL DATABASES
SHOW DATABASES;

-- CREATE A NEW DATABASE NAMED 'challenges'
CREATE DATABASE challenges;

-- SELECT THE CURRENT DATABASE
SELECT DATABASE();

-- SWITCH TO THE 'challenges' DATABASE
USE challenges;

-- SHOW ALL TABLES IN THE CURRENT DATABASE
SHOW TABLES;

-- CREATE 'students' TABLE
CREATE TABLE students (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20)
);

-- CREATE 'papers' TABLE WITH A FOREIGN KEY TO 'students'
CREATE TABLE papers (
    title VARCHAR(50) NOT NULL,
    grade DECIMAL(4,2) NOT NULL DEFAULT 30.00,
    student_id INT,
    FOREIGN KEY (student_id) REFERENCES students(id)
);

-- INSERT SAMPLE DATA INTO 'students'
INSERT INTO students (first_name) VALUES
('Caleb'), ('Samantha'), ('Raj'), ('Carlos'), ('Lisa');

-- INSERT SAMPLE DATA INTO 'papers'
INSERT INTO papers (student_id, title, grade ) VALUES
(1, 'My First Book Report', 60),
(1, 'My Second Book Report', 75),
(2, 'Russian Lit Through The Ages', 94),
(2, 'De Montaigne and The Art of The Essay', 98),
(4, 'Borges and Magical Realism', 89);

-- RETRIEVE ALL STUDENT-PAPER RECORDS, ORDERED BY GRADE (DESCENDING)
SELECT s.first_name, p.title, p.grade
FROM papers p
INNER JOIN students s ON p.student_id = s.id
ORDER BY p.grade DESC;

-- LIST ALL STUDENTS AND THEIR PAPERS (IF ANY)
SELECT s.first_name, p.title, p.grade
FROM students s
LEFT JOIN papers p ON s.id = p.student_id;

-- SHOW STUDENT NAMES WITH PAPER DETAILS, REPLACING NULLS WITH 'MISSING' OR 0
SELECT s.first_name, IFNULL(p.title, 'MISSING') AS title, IFNULL(p.grade, 0) AS grade
FROM students s
LEFT JOIN papers p ON s.id = p.student_id;

-- CALCULATE THE AVERAGE GRADE PER STUDENT, SORTED IN DESCENDING ORDER
SELECT s.first_name, IFNULL(AVG(p.grade), 0) AS average
FROM students s
LEFT JOIN papers p ON s.id = p.student_id
GROUP BY s.first_name
ORDER BY average DESC;

-- DETERMINE STUDENT PASSING STATUS BASED ON AVERAGE GRADE
SELECT s.first_name,
       IFNULL(AVG(p.grade), 0) AS average,
       CASE
           WHEN IFNULL(AVG(p.grade), 0) >= 75 THEN 'PASSING'
           ELSE 'FAILING'
       END AS passing_status
FROM students s
LEFT JOIN papers p ON s.id = p.student_id
GROUP BY s.first_name
ORDER BY average DESC;
