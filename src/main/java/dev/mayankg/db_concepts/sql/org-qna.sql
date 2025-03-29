# SQL QnAs

-- Q-01. Write a SQL query to fetch 'FIRST_NAME' from Worker table using the alias name as Worker_Name.
SELECT first_name AS Worker_Name FROM Worker;

-- Q-02. Write a SQL query to fetch 'FIRST_NAME' from the 'Worker' table in upper case.
SELECT upper(first_name) AS WORKER_FIRST_NAME FROM Worker;

-- Q-03. Write a SQL query to fetch unique values of DEPARTMENT from the Worker table.
SELECT DISTINCT DEPARTMENT FROM Worker;
-- OR
SELECT Department FROM Worker GROUP BY Department;

-- Q-04. Write a SQL query to print the first three characters of the FIRST_NAME from the Worker table.
SELECT substring(first_name, 1, 3) as FN FROM Worker;
-- OR
SELECT substr(first_name, 1, 3) as FN FROM Worker;

-- Q-05. Write a SQL query to find the position of the alphabet ('b') in the FIRST_NAME where first name is 'Amitabh' from the Worker table.
SELECT instr(first_name, 'b') AS 'POSITION OF B' FROM Worker WHERE FIRST_NAME = 'Amitabh';

-- Q-06. Write a SQL query to print the FIRST_NAME from the Worker table after removing unique white spaces from the right side.
SELECT rtrim(first_name) as 'F.Name' FROM Worker;

-- Q-07. Write a SQL query to print the FIRSt_NAME from the Worker table after removing unique white spaces from the left side.
SELECT ltrim(first_name) as 'F.Name' FROM Worker;

-- Q-08. Write a SQL query to fetch the unique values of the DEPARTMENT from the Worker table and print its length.
SELECT Department, length(department) AS Length FROM Worker GROUP BY Department;

-- Q-09. Write a SQL query to print the FIRST_NAME from the Worker table after replacing 'a' with 'A'.
SELECT replace(first_name, 'a', 'A') AS 'first nAme' FROM Worker;

-- Q-10. Write a SQL query to print the FIRST_NAME and LAST_NAME from the Worker table into a single column as FULL_NAME. 
SELECT concat(FIRST_NAME, ' ', LAST_NAME) AS 'Full Name' FROM Worker;

-- Q-11. Write a SQL query to print all Worker details from the Worker table and order them by FIRST_NAME in ascending.
SELECT * FROM Worker ORDER BY first_name ASC;

-- Q-12. Write a SQL query to print all the details for the Worker table and order them by FIRST_NAME in ascending and DEPARTMENT descending.
SELECT * FROM Worker ORDER BY first_name ASC, department DESC;

-- Q-13. Write a SQL query to print details for the Workers with the FIRST_NAME as 'Vipul' and 'Satish' from the Worker table.
SELECT * FROM Worker WHERE first_name IN ('Vipul', 'Satish');

-- Q-14. Write a SQL query to print details for the Workers with the FIRST_NAME not as 'Vipul' or 'Satish' from the Worker table.
SELECT * FROM Worker WHERE first_name NOT IN ('Vipul', 'Satish');

-- Q-15. Write a SQL query to print details of the Workers with DEPARTMENT as 'ADMIN' from the Worker table.
SELECT * FROM Worker WHERE department = 'admin';

-- Q-16. Write a SQL query to print the details of the workers whoese FIRST_NAME contains 'a'.
SELECT * FROM Worker WHERE first_name LIKE '%a%';

-- Q-17. Write a SQL query to print the details of the workers whoese FIRST_NAME ends with 'a'.
SELECT * FROM Worker WHERE first_name LIKE '%a';

-- Q-18. Write a SQL query to print the details of the workers whoese FIRST_NAME ends with 'h' and contains six alphabets.
SELECT * FROM Worker WHERE first_name LIKE '_____h';

-- Q-19. Write a SQL query to print details of the workers whose SALARY lies between 100000 and 500000.
SELECT * FROM Worker WHERE salary >= 100000 AND salary <= 500000;
-- OR
SELECT * FROM Worker WHERE salary BETWEEN 100000 AND 500000;

-- Q-20. Write a SQL query to print the details of the workers who joined in Feb'2014.
SELECT * FROM Worker WHERE year(joining_date)=2014 AND month(joining_date)=02;

-- Q-21. Write a SQL query to fetch the count of workers whose DEPARTMENT is 'Admin'.
SELECT count(worker_id) AS Count FROM Worker WHERE department = 'admin';

-- Q-22. Write a SQL query to fetch the worker's full name with salaries >= 50000 and salaries <= 100000.
SELECT concat(first_name, ' ', last_name) AS 'Full Name' FROM Worker WHERE salary BETWEEN 50000 AND 100000;

-- Q-23. Write a SQL query to fetch the number of workers in each department in descending order of the count.
SELECT department, count(worker_id) AS WorkerCount FROM Worker GROUP BY department ORDER BY WorkerCount DESC;

-- Q-24. Write a SQL query to print the details of workers who are also 'Managers'.
SELECT w.*, t.WORKER_TITLE FROM worker AS w LEFT JOIN title AS t ON w.WORKER_ID = t.WORKER_REF_ID WHERE t.WORKER_TITLE='manager';

-- Q-25. Write a SQL query to print the different titles in the ORG whose worker count > 1.
SELECT t.WORKER_TITLE, count(*) FROM org.title AS t GROUP BY t.WORKER_TITLE HAVING count(*) > 1;

-- Q-26. Write a SQL query to show only odd rows from the worker table.
SELECT * FROM org.worker AS w WHERE mod(w.worker_id, 2) != 0;
-- OR
SELECT * FROM org.worker AS w WHERE mod(w.worker_id, 2) <> 0;

-- Q-27. Write a SQL query to show only even rows from the worker table.
SELECT * FROM org.worker AS w WHERE mod(w.worker_id, 2) = 0;

-- Q-28. Write a SQL query to clone a new table from worker table.
CREATE TABLE org.worker_clone LIKE org.worker;
INSERT INTO org.worker_clone SELECT * FROM org.worker;
SELECT * FROM org.worker_clone;

-- Q-29. Write a SQL query to fetch the intersecting records from two tables.
SELECT * FROM org.worker AS w INNER JOIN org.bonus AS b ON w.WORKER_ID=b.WORKER_REF_ID;
-- OR
SELECT * FROM org.worker INNER JOIN org.worker_clone USING(worker_id);

-- Q-30. Write a SQL query to show the records of one table that another table doesn't have.
SELECT w.* FROM worker AS w LEFT JOIN worker_clone AS wc ON w.WORKER_ID=wc.WORKER_ID WHERE wc.WORKER_ID IS NULL;

-- Q-31. Write a SQL query to show the current date and time.
SELECT now() AS 'Current Date-Time';

-- Q-32. Write a SQL query to show the top 5 records of a table and order by descending using 'SALARY'.
SELECT * FROM org.worker AS w ORDER BY w.SALARY DESC LIMIT 5;

-- Q-33. Write a SQL query to show the fifth highest salary from the Worker table.
SELECT * FROM org.worker AS w ORDER BY w.SALARY DESC LIMIT 4,1;

-- Q-34. Write a SQL query to show the fifth highest salary from the Worker table without using the LIMIT keyword (HINT: using co-related sub-query).
SELECT w1.* FROM worker AS w1
WHERE 4 = (
	SELECT count(DISTINCT w2.salary) 
	FROM worker AS w2
	WHERE w2.SALARY >= w1.SALARY
);

-- Q-35. Write a SQL query to fetch the list of workers with same salary from the Worker table.
SELECT w1.* FROM worker AS w1, worker AS w2 WHERE w1.SALARY=w2.SALARY AND w1.WORKER_ID!=w2.WORKER_ID;

-- Q-36. Write a SQL query to show the second highest salary from the Worker table (HINT: only using sub-query).
SELECT max(salary) from worker WHERE salary NOT IN (SELECT max(salary) from worker);

-- Q-37. Write a SQL query to show the one row twice in the result from Worker table.
SELECT * FROM worker
UNION ALL
SELECT * FROM worker ORDER BY worker_id;

-- Q-38. Write a SQL query to list WORKER_ID for workers who did not got the bonus.
SELECT w.worker_id FROM worker as w LEFT JOIN bonus as b ON w.worker_id=b.worker_ref_id WHERE b.BONUS_AMOUNT IS NULL;
-- OR 
SELECT worker_id FROM worker WHERE worker_id NOT IN (SELECT b.worker_ref_id from bonus as b);

-- Q-39. Write a SQL query to fetch the first 50% records from the Worker table.
SELECT * FROM worker WHERE worker_id <= (SELECT count(worker_id)/2 FROM worker);

-- Q-40. Write a SQL query to list all the DEPARTMENTS that have less than 4 worker in it.
SELECT department FROM worker GROUP BY department HAVING count(department) < 4;

-- Q-41. Write a SQL query to list all the DEPARTMENTS and the number of workers in it.
SELECT department, count(department) AS count FROM worker GROUP BY department;

-- Q-42. Write a SQL query to show the last record from the Worker table.
SELECT * FROM worker WHERE worker_id = (SELECT max(worker_id) from worker);
-- OR
SELECT * FROM worker ORDER BY worker_id DESC LIMIT 1;

-- Q-43. Write a SQL query to fetch the first row of the Worker table.
SELECT * FROM worker WHERE worker_id = (SELECT min(worker_id) from worker);
-- OR
SELECT * FROM worker ORDER BY worker_id ASC LIMIT 1;

-- Q-44. Write a SQL query to fetch the last 5 records of the Worker table.
(SELECT * FROM worker ORDER BY worker_id DESC LIMIT 5) ORDER BY worker_id;

-- Q-45. Write a SQL query to print the name of employees having the highest salary in each DEPARTMENT.
SELECT w.department, w.first_name, w.salary FROM
(SELECT department, max(salary) as max_salary FROM Worker GROUP BY department) AS tmp
INNER JOIN worker w ON w.department=tmp.department AND w.salary=tmp.max_salary;

-- Q-46. Write a SQL query to fetch three max salaries from a table using co-related subquery.
SELECT DISTINCT salary FROM worker ORDER BY salary DESC LIMIT 3;
-- OR
SELECT DISTINCT salary from worker w1 
WHERE 3>= (SELECT count(DISTINCT salary) FROM worker w2 WHERE w1.salary<=w2.salary) 
ORDER BY w1.salary DESC;

-- Q-47. Write a SQL query to fetch three min salaries from a table using the co-related subquery.
SELECT DISTINCT salary from worker w1 
WHERE 3>= (SELECT count(DISTINCT salary) FROM worker w2 WHERE w1.salary>=w2.salary) 
ORDER BY w1.salary ASC;

-- Q-48. Write a SQL query to fetch the 2nd highest salary from the Worker table using co-related sub-query.
SELECT DISTINCT salary from worker w1 
WHERE 2= (SELECT count(DISTINCT salary) FROM worker w2 WHERE w1.salary<=w2.salary);

-- Q-49. Write a SQL query to fetch DEPARTMENTS along with the total salaries paid for each of them.
SELECT department, sum(salary) 'total salary' FROM worker GROUP BY department;

-- Q-50. Write a SQL query to fetch the names of workers who earn the highest salaries.
SELECT concat(first_name, ' ', last_name) AS Name FROM worker WHERE salary = (SELECT max(salary) FROM worker);