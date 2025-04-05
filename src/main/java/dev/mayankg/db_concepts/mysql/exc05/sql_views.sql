-- FULL JOINED REVIEW QUERY (USED FREQUENTLY)
SELECT title, released_year, genre, rating, first_name, last_name
FROM reviews
    JOIN series ON series.id = reviews.series_id
    JOIN reviewers ON reviewers.id = reviews.reviewer_id;

-- CREATING A VIEW FOR THE ABOVE QUERY
CREATE VIEW full_reviews AS
SELECT title, released_year, genre, rating, first_name, last_name
FROM reviews
    JOIN series ON series.id = reviews.series_id
    JOIN reviewers ON reviewers.id = reviews.reviewer_id;

-- USING THE VIEW LIKE A VIRTUAL TABLE
SELECT * FROM full_reviews;

-- CREATING A VIEW TO ORDER SERIES BY YEAR (ASCENDING)
CREATE VIEW ordered_series AS
SELECT * FROM series
ORDER BY released_year;

-- REPLACING THE VIEW TO ORDER BY YEAR (DESCENDING)
CREATE OR REPLACE VIEW ordered_series AS
SELECT * FROM series
ORDER BY released_year DESC;

-- ALTERING EXISTING VIEW TO CHANGE SORT ORDER
ALTER VIEW ordered_series AS
SELECT * FROM series
ORDER BY released_year;

-- DROPPING THE VIEW
DROP VIEW ordered_series;

-- AGGREGATE: AVERAGE RATINGS FOR SERIES WITH MORE THAN 1 REVIEW
SELECT
    title,
    AVG(rating) AS avg_rating,
    COUNT(rating) AS review_count
FROM full_reviews
GROUP BY title
HAVING COUNT(rating) > 1;

-- AGGREGATE WITH ROLLUP: AVERAGE RATING PER TITLE
SELECT
    title,
    AVG(rating) AS avg_rating
FROM full_reviews
GROUP BY title WITH ROLLUP;

-- AGGREGATE WITH ROLLUP: REVIEW COUNT PER TITLE
SELECT
    title,
    COUNT(rating) AS review_count
FROM full_reviews
GROUP BY title WITH ROLLUP;

-- MULTI-COLUMN GROUPING WITH ROLLUP: AVG RATINGS PER REVIEWER/YEAR/GENRE
SELECT
    first_name,
    released_year,
    genre,
    AVG(rating) AS avg_rating
FROM full_reviews
GROUP BY released_year, genre, first_name WITH ROLLUP;

-- To View Modes:
SELECT @@GLOBAL.sql_mode;
SELECT @@SESSION.sql_mode;

-- To Set Them:
SET GLOBAL sql_mode = 'modes';
SET SESSION sql_mode = 'modes';