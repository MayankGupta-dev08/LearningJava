-- What's a good use case for CHAR?

-- Used for text that we know has a fixed length, e.g., State abbreviations,
-- abbreviated company names, etc.

CREATE TABLE inventory (
    item_name VARCHAR(100),
    price DECIMAL(8,2),
    quantity INT
);

-- What's the difference between DATETIME and TIMESTAMP?

-- They both store datetime information, but there's a difference in the range,
-- TIMESTAMP has a smaller range. TIMESTAMP also takes up less space.
-- TIMESTAMP is used for things like meta-data about when something is created
-- or updated.


-- Get the current time
SELECT CURTIME();

-- Get the current date
SELECT CURDATE();

-- Get the day of the week for the current date (1 = Sunday, 7 = Saturday)
SELECT DAYOFWEEK(CURDATE());

-- Get the day of the week for the current timestamp
SELECT DAYOFWEEK(NOW());

-- Get the day of the week (1 = Sunday, 7 = Saturday) using DATE_FORMAT
SELECT DATE_FORMAT(NOW(), '%w') + 1;

-- Get the name of the current day
SELECT DAYNAME(NOW());

-- Get the full weekday name of the current date
SELECT DATE_FORMAT(NOW(), '%W');

-- Format the current date as MM/DD/YYYY
SELECT DATE_FORMAT(CURDATE(), '%m/%d/%Y');

-- Format the current timestamp as "Month Day at Hour:Minute"
SELECT DATE_FORMAT(NOW(), '%M %D at %k:%i');

-- Create a table to store tweets
CREATE TABLE tweets (
    content VARCHAR(140),
    username VARCHAR(20),
    created_at TIMESTAMP DEFAULT NOW()
);

-- Insert a new tweet into the table
INSERT INTO tweets (content, username)
VALUES ('this is my first tweet', 'coltscat');

-- Retrieve all tweets
SELECT * FROM tweets;

-- Insert another tweet into the table
INSERT INTO tweets (content, username)
VALUES ('this is my second tweet', 'coltscat');

-- Retrieve all tweets again
SELECT * FROM tweets;
