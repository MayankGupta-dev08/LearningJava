-- VIEW ALL RECORDS
SELECT * FROM employees;

-- MIN and MAX salary from the employees table
SELECT
	AVG(salary) AS avg_salary,
    MIN(salary) AS min_salary,
    MAX(salary) AS max_salary
FROM employees;

-- SHOW EMPLOYEE DETAILS ALONG WITH OVERALL AVERAGE SALARY USING WINDOW FUNCTION
SELECT
    emp_no,
    department,
    salary,
    AVG(salary) OVER() AS avg_salary
FROM employees;

-- AGGREGATE MIN AND MAX SALARIES (WITHOUT WINDOW FUNCTION) - RESULTS IN SINGLE ROW PER GROUP (IF GROUPED)
-- results in EXCEPTION if not grouped
-- SELECT
--     emp_no,
--     department,
--     salary,
--     MIN(salary) AS min_salary,
--     MAX(salary) AS max_salary
-- FROM employees;

-- AGGREGATE MIN AND MAX SALARIES (WITHOUT WINDOW FUNCTION) - RESULTS IN SINGLE ROW PER GROUP (IF GROUPED)
SELECT
    department,
	AVG(salary) AS avg_salary,
    MIN(salary) AS min_salary,
    MAX(salary) AS max_salary
FROM employees
GROUP BY department;

-- SHOW EMPLOYEE DETAILS ALONG WITH MIN AND MAX SALARIES ACROSS ALL ROWS
SELECT
    emp_no,
    department,
    salary,
    MIN(salary) OVER() AS min_salary,
    MAX(salary) OVER() AS max_salary
FROM employees;

-- SHOW EMPLOYEE DETAILS ALONG WITH MIN AND MAX SALARIES PER DEPARTMENT
SELECT
    emp_no,
    department,
    salary,
    AVG(salary) OVER(PARTITION BY department) AS dep_avg_salary,
    MIN(salary) OVER(PARTITION BY department) AS dep_min_salary,
    MAX(salary) OVER(PARTITION BY department) AS dep_max_salary
FROM employees;

-- SHOW EMPLOYEE DETAILS ALONG WITH MIN AND MAX SALARIES PER DEPARTMENT
SELECT
    emp_no,
    department,
    salary,
    SUM(salary) OVER(PARTITION BY department) AS dept_payroll,
    SUM(salary) OVER() AS total_payroll
FROM employees;