-- Retrieve all book titles that contain the word 'stories'
SELECT title
FROM books b
WHERE title LIKE '%stories%';

-- Find the book with the highest number of pages
SELECT title, pages
FROM books
ORDER BY pages DESC
LIMIT 1;

-- Retrieve the latest 3 books with their release years, formatted as "title - released_year"
SELECT CONCAT(title, ' - ', released_year) AS summary
FROM books
ORDER BY released_year DESC
LIMIT 3;

-- Find books where the author's last name contains a space (i.e., double-barreled or compound surnames)
SELECT b.title, b.author_lname
FROM books b 
WHERE b.author_lname LIKE '% %';

-- Retrieve the 3 books with the lowest stock quantity
SELECT b.title, b.released_year, b.stock_quantity
FROM books b
ORDER BY b.stock_quantity ASC
LIMIT 3;

-- List all books sorted by author's last name, and then by title
SELECT b.title, b.author_lname
FROM books b
ORDER BY b.author_lname, b.title;

-- Generate a sentence in uppercase, stating the user's favorite author, sorted by last name
SELECT UPPER(CONCAT('My favorite author is ', b.author_fname, ' ', b.author_lname, '!')) AS yell
FROM books b
ORDER BY b.author_lname;
