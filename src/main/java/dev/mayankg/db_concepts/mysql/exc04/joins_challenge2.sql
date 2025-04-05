-- Select the current database
SELECT DATABASE();

-- Show all databases
SHOW DATABASES;

-- Switch to the 'challenges' database
USE challenges;

-- Show all tables in the current database
SHOW TABLES;

-- Select all data from the 'reviewers' table
SELECT * FROM reviewers;

-- Select all data from the 'series' table
SELECT * FROM series;

-- Select all data from the 'reviews' table
SELECT * FROM reviews;

-- Join 'series' and 'reviews' to get series title and corresponding ratings
SELECT s.title, r.rating
FROM series s
JOIN reviews r ON s.id = r.series_id;

-- Get average rating per series, ordered by lowest to highest average rating
SELECT s.title, ROUND(AVG(r.rating), 2) AS avg_rating
FROM series s
JOIN reviews r ON s.id = r.series_id
GROUP BY s.title
ORDER BY avg_rating ASC;

-- Join reviewers with their reviews
SELECT r.first_name, r.last_name, r2.rating
FROM reviewers r
INNER JOIN reviews r2 ON r.id = r2.reviewer_id;

-- Find series that have not received any reviews
SELECT s.title AS unreviewed_series
FROM series s
LEFT JOIN reviews r ON s.id = r.series_id
WHERE r.rating IS NULL;

-- Get average rating per genre, sorted by average
SELECT s.genre, ROUND(AVG(r.rating), 2) AS avg_rating
FROM series s
JOIN reviews r ON s.id = r.series_id
GROUP BY s.genre
ORDER BY avg_rating;

-- Reviewer summary: total ratings, min, max, avg rating, and activity status
SELECT
    r1.first_name,
    r1.last_name,
    COUNT(r2.rating) AS number_ratings,
    IFNULL(MIN(r2.rating), 0) AS min_rating,
    IFNULL(MAX(r2.rating), 0) AS max_rating,
    IFNULL(ROUND(AVG(r2.rating), 2), 0) AS avg_rating,
    CASE
        WHEN IFNULL(MIN(r2.rating), 0) = 0 THEN 'INACTIVE'
        ELSE 'ACTIVE'
    END AS status
FROM reviewers r1
LEFT JOIN reviews r2 ON r1.id = r2.reviewer_id
GROUP BY r1.first_name, r1.last_name
ORDER BY r1.first_name, r1.last_name ASC;

-- Get all reviews with series title and reviewer name
SELECT
    s.title,
    r1.rating,
    CONCAT(r2.first_name, ' ', r2.last_name)
FROM reviews r1
INNER JOIN series s ON s.id = r1.series_id
INNER JOIN reviewers r2 ON r1.reviewer_id = r2.id;
