-- Count the total number of books in the table
SELECT COUNT(*) AS number_of_books
FROM books b;

-- Count the number of books released in each year and order them by year
SELECT b.released_year, COUNT(*) AS book_count
FROM books b
GROUP BY b.released_year
ORDER BY b.released_year;

-- Calculate the total stock quantity of all books
SELECT SUM(b.stock_quantity) AS total_stock
FROM books b;

-- Count how many books have the same stock quantity
SELECT stock_quantity, COUNT(*) AS book_count
FROM books b
GROUP BY stock_quantity;

-- Find the average release year for each author (grouped by full name)
SELECT CONCAT(b.author_fname, ' ', b.author_lname) AS author,
       AVG(b.released_year) AS avg_release_year
FROM books b
GROUP BY b.author_fname, b.author_lname;

-- Find the author of the book with the maximum number of pages
SELECT CONCAT(b.author_fname, ' ', b.author_lname) AS author_name
FROM books b
WHERE pages = (SELECT MAX(pages) FROM books);

-- Count the number of books released per year and calculate the average number of pages per year
SELECT b.released_year AS year,
       COUNT(*) AS books,
       AVG(pages) AS avg_pages
FROM books b
GROUP BY b.released_year
ORDER BY b.released_year;
