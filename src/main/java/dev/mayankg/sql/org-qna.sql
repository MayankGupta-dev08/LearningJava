# SQL QnAs

-- Q-01. Write a SQL query to fetch 'FIRST_NAME' from Worker table using the alias name as Worker_Name.
SELECT first_name AS Worker_Name FROM Worker;

-- Q-02. Write a SQL query to fetch 'FIRST_NAME' from the 'Worker' table in upper case.
SELECT upper(first_name) AS WORKER_FIRST_NAME FROM Worker;

-- Q-03. Write a SQL query to fetch unique values of DEPARTMENT from the Worker table.
SELECT DISTINCT DEPARTMENT FROM Worker; 
SELECT Department FROM Worker GROUP BY Department;

-- Q-04. Write a SQL query to print the first three characters of the FIRST_NAME from the Worker table.
SELECT substring(first_name, 1, 3) as FN FROM Worker;
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
SELECT w.*, t.WORKER_TITLE FROM worker AS w INNER JOIN title AS t ON w.WORKER_ID = t.WORKER_REF_ID WHERE t.WORKER_TITLE='manager';

-- Q-25. Write a SQL query to print the different titles in the ORG whose worker count > 1.


-- Q-26. Write a SQL query to show only odd rows from the worker table.


-- Q-27. Write a SQL query to show only even rows from the worker table.


-- Q-28. Write a SQL query to clone a new table from worker table.


-- Q-29. Write a SQL query to fetch the intersecting records from two tables.


-- Q-30. Write a SQL query to show the records of one table that another table doesn't have.


-- Q-31. Write a SQL query to show the current date and time.


-- Q-32. Write a SQL query to show the top 5 records of a table and order by descending using 'SALARY'.


-- Q-33. Write a SQL query to show the fifth highest salary from the Worker table.


-- Q-34. Write a SQL query to show the fifth highest salary from the Worker table without using the LIMIT keyword.


-- Q-35. Write a SQL query to fetch the list of workers with same salary from the Worker table.


-- Q-36. Write a SQL query to show the second highest salary from the Worker table.


-- Q-37. Write a SQL query to show the one row twice in the result from Worker table.


-- Q-38. Write a SQL query to list WORKER_ID for workers who did not got the bonus.


-- Q-39. Write a SQL query to fetch the first 50% records from the Worker table.


-- Q-40. Write a SQL query to list all the DEPARTMENTS that have less than 1 worker in it.


-- Q-41. Write a SQL query to list all the DEPARTMENTS and the number of workers in it.


-- Q-42. Write a SQL query to show the last record from the Worker table.


-- Q-43. Write a SQL query to fetch the first row of the Worker table.


-- Q-44. Write a SQL query to fetch the last 5 records of the Worker table.


-- Q-45. Write a SQL query to print the name of employees having the highest salary in each DEPARTMENT.


-- Q-46. Write a SQL query to fetch three max salaries from a table using co-related subquery.


-- Q-47. Write a SQL query to fetch three min salaries from a table using the co-related subquery.


-- Q-48. Write a SQL query to fetch the nth max salaries from the Worker table.


-- Q-49. Write a SQL query to fetch DEPARTMENTS along with the total salaries paid for each of them.


-- Q-50. Write a SQL query to fetch the names of workers who earn the highest salaries.


-- Q-51. Write a SQL query to