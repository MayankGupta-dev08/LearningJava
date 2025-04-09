-- VIEW ALL EMPLOYEE RECORDS
SELECT * FROM employees;

-- CALCULATE OVERALL AVERAGE, MINIMUM, AND MAXIMUM SALARY ACROSS ALL EMPLOYEES
SELECT
    AVG(salary) AS avg_salary,
    MIN(salary) AS min_salary,
    MAX(salary) AS max_salary
FROM employees;

-- SHOW EACH EMPLOYEE'S DETAILS WITH THE OVERALL AVERAGE SALARY USING A WINDOW FUNCTION
-- Does not collapse rows — average appears on each row
SELECT
    emp_no,
    department,
    salary,
    AVG(salary) OVER() AS avg_salary
FROM employees;

-- ⚠️ THIS QUERY IS COMMENTED OUT BECAUSE IT WOULD THROW AN ERROR
-- IT TRIES TO USE AGGREGATE FUNCTIONS WITHOUT GROUPING OR A WINDOW FUNCTION
-- SELECT
--     emp_no,
--     department,
--     salary,
--     MIN(salary) AS min_salary,
--     MAX(salary) AS max_salary
-- FROM employees;

-- SHOW AVERAGE, MINIMUM, AND MAXIMUM SALARIES PER DEPARTMENT
-- GROUPS DATA BY DEPARTMENT AND RETURNS ONE ROW PER DEPARTMENT
SELECT
    department,
    AVG(salary) AS avg_salary,
    MIN(salary) AS min_salary,
    MAX(salary) AS max_salary
FROM employees
GROUP BY department;

-- SHOW EACH EMPLOYEE'S DETAILS ALONG WITH OVERALL MIN AND MAX SALARIES USING WINDOW FUNCTION
-- MIN() and MAX() are calculated once over the full table and shown with each row
SELECT
    emp_no,
    department,
    salary,
    MIN(salary) OVER() AS min_salary,
    MAX(salary) OVER() AS max_salary
FROM employees;

-- SHOW EACH EMPLOYEE'S DETAILS WITH DEPARTMENT-WISE AVERAGE, MIN, AND MAX SALARIES
-- Uses PARTITION BY department to group inside the window function
SELECT
    emp_no,
    department,
    salary,
    AVG(salary) OVER(PARTITION BY department) AS dep_avg_salary,
    MIN(salary) OVER(PARTITION BY department) AS dep_min_salary,
    MAX(salary) OVER(PARTITION BY department) AS dep_max_salary
FROM employees;

-- SHOW EACH EMPLOYEE'S DETAILS WITH DEPARTMENT-WISE AND OVERALL PAYROLL (TOTAL SALARY SUM)
-- Uses SUM() as a window function for both scoped and global totals
SELECT
    emp_no,
    department,
    salary,
    SUM(salary) OVER(PARTITION BY department) AS dept_payroll,
    SUM(salary) OVER() AS total_payroll
FROM employees;

-- SHOW EACH EMPLOYEE'S DETAILS ALONG WITH ROLLING SUM (CUMULATIVE) OF SALARIES PER DEPARTMENT
-- Uses ORDER BY inside the window function to generate cumulative total by salary within each department
SELECT
    emp_no,
    department,
    salary,
    SUM(salary) OVER(PARTITION BY department ORDER BY salary) AS rolling_dept_payroll,
    SUM(salary) OVER(PARTITION BY department) AS dept_payroll
FROM employees;

-- SHOW EACH EMPLOYEE'S DETAILS WITH DEPARTMENT-WISE ROLLING MINIMUM SALARY IN DESCENDING ORDER
-- Shows minimum salary seen so far as we move from highest to lowest in each department
SELECT
    emp_no,
    department,
    salary,
    MIN(salary) OVER(PARTITION BY department ORDER BY salary DESC) AS rolling_min
FROM employees;

-- SHOW EMPLOYEE DETAILS ALONG WITH ROW NUMBER, RANK, AND DENSE_RANK FOR SALARIES
-- Demonstrates use of window functions to rank employees within department and overall
SELECT
    emp_no,
    department,
    salary,

    -- Assigns a unique row number per department based on descending salary
    ROW_NUMBER() OVER(PARTITION BY department ORDER BY salary DESC) AS dept_row_number,

    -- Ranks salaries within each department (duplicates get same rank, next rank is skipped)
    RANK() OVER(PARTITION BY department ORDER BY salary DESC) AS dept_salary_rank,

    -- Overall ranking across all departments (standard rank)
    RANK() OVER(ORDER BY salary DESC) AS overall_rank,

    -- Overall dense rank (no gaps in ranks for ties)
    DENSE_RANK() OVER(ORDER BY salary DESC) AS overall_dense_rank,

    -- Assigns a unique row number to each row based on overall descending salary
    ROW_NUMBER() OVER(ORDER BY salary DESC) AS overall_num

FROM employees
ORDER BY overall_rank;

-- ASSIGN EACH EMPLOYEE TO A SALARY QUARTILE (Q1–Q4)
-- Uses NTILE(4) to divide employees into 4 equal salary-based buckets
-- Computes quartiles both department-wise and across the entire organization
SELECT
    emp_no,
    department,
    salary,
    NTILE(4) OVER(PARTITION BY department ORDER BY salary DESC) AS dept_salary_quartile,
    NTILE(4) OVER(ORDER BY salary DESC) AS salary_quartile
FROM employees;

-- IDENTIFY THE HIGHEST-PAID EMPLOYEE PER DEPARTMENT AND OVERALL
-- FIRST_VALUE returns the emp_no with the highest salary per partition
SELECT
    emp_no,
    department,
    salary,
    FIRST_VALUE(emp_no) OVER(PARTITION BY department ORDER BY salary DESC) AS highest_paid_dept,
    FIRST_VALUE(emp_no) OVER(ORDER BY salary DESC) AS highest_paid_overall
FROM employees;

-- CALCULATE SALARY DIFFERENCE COMPARED TO THE PREVIOUS EMPLOYEE IN DESCENDING SALARY ORDER (OVERALL)
-- LAG() fetches the previous row’s salary for comparison
SELECT
    emp_no,
    department,
    salary,
    salary - LAG(salary) OVER(ORDER BY salary DESC) AS salary_diff
FROM employees;

-- CALCULATE SALARY DIFFERENCE WITHIN EACH DEPARTMENT COMPARED TO THE NEXT LOWER PAID EMPLOYEE
-- Uses LAG() within department partition to show gaps between adjacent salaries
SELECT
    emp_no,
    department,
    salary,
    salary - LAG(salary) OVER(PARTITION BY department ORDER BY salary DESC) AS dept_salary_diff
FROM employees;
