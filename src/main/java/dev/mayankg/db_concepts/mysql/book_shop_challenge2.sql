-- Select all columns from the 'books' table
-- How do you retrieve all records from a table?
SELECT * FROM books b;

-- Reverse the uppercase version of a given string
-- How do you convert a string to uppercase and then reverse it?
SELECT REVERSE(UPPER('Why does my cat look at me with such a hatered?'));

-- Replace spaces with hyphens in a concatenated string
-- How do you concatenate strings and replace spaces with a specific character?
SELECT REPLACE(CONCAT('i', ' ', 'like', ' ', 'cats'), ' ', '-');

-- Replace spaces in book titles with '->'
-- How do you replace spaces in a column's values with a specific character?
SELECT REPLACE(title, ' ', '->') AS title
FROM books;

-- Select author’s last name in normal and reversed order
-- How do you display a string and its reversed version from a table?
SELECT b.author_lname AS forwards,
       REVERSE(b.author_lname) AS backwards
FROM books b;

-- Display full name in uppercase format
-- How do you concatenate first and last names while converting them to uppercase?
SELECT UCASE(CONCAT_WS(' ', b.author_fname, b.author_lname)) AS FULL_NAME
FROM books b;

-- Concatenate book title with release year in a sentence format
-- How do you combine two columns into a single sentence?
SELECT CONCAT(b.title, ' was released in ', b.released_year) AS blurb
FROM books b;

-- Show book titles along with their character count
-- How do you count the number of characters in a column value?
SELECT b.title,
       CHAR_LENGTH(b.title) AS 'character count'
FROM books b;

-- Shorten book titles to 10 characters and display author details and stock quantity
-- How do you extract a substring, format author names, and append stock details?
SELECT CONCAT(SUBSTR(title, 1, 10), '...') AS 'short title',
       CONCAT_WS(',', b.author_lname, b.author_fname) AS author,
       CONCAT(b.stock_quantity, ' in stock') AS quantity
FROM books b;
