-- Select all books released before 1980
SELECT *
FROM book_shop.books b
WHERE b.released_year < 1980;

-- Select all books written by authors with last names 'Eggers' or 'Chabon'
SELECT *
FROM books b
WHERE b.author_lname IN ('Eggers', 'Chabon');

-- Select all books written by 'Lahiri' and released in or after the year 2000
SELECT *
FROM books b
WHERE b.author_lname = 'Lahiri'
AND b.released_year >= 2000;

-- Select all books where the number of pages is between 100 and 200
SELECT *
FROM books b
WHERE b.pages BETWEEN 100 AND 200;

-- Select all books written by authors whose last names start with 'C' or 'S'
SELECT *
FROM books b
WHERE b.author_lname LIKE 'C%'
   OR b.author_lname LIKE 'S%';

-- or other way to do the same
SELECT *
FROM books b
WHERE b.author_lname REGEXP '^[CS]';

-- or other way to do the same
SELECT *
FROM books b
WHERE SUBSTR(b.author_lname, 1, 1) IN ('C', 'S');


-- Classify books based on their title
SELECT b.title,
       b.author_lname,
       CASE
           WHEN title LIKE '%stories%' THEN 'Short Stories'
           WHEN title IN ('Just Kids', 'A Heartbreaking Work') THEN 'Memoir'
           ELSE 'Novel'
       END AS type
FROM books b;

-- Count the number of books each author has written and format the output
SELECT b.author_fname,
       b.author_lname,
       CASE
           WHEN COUNT(*) = 1 THEN CONCAT(COUNT(*), ' book')
           ELSE CONCAT(COUNT(*), ' books')
       END AS count
FROM books b
GROUP BY b.author_fname, b.author_lname;
