-- Create a contacts table with unique phone numbers
CREATE TABLE contacts (
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL UNIQUE
);

-- Insert a valid contact
INSERT INTO contacts (name, phone)
VALUES ('billybob', '8781213455');

-- This will cause an error due to UNIQUE constraint violation on phone
-- INSERT INTO contacts (name, phone)
-- VALUES ('billybob', '8781213455');

-- Create a users table with a CHECK constraint on age
CREATE TABLE users (
    username VARCHAR(20) NOT NULL,
    age INT CHECK (age > 0)
);

-- Attempt to create a palindromes table with a CHECK using REVERSE (this will likely fail in many RDBMS as REVERSE is not allowed in CHECK)
CREATE TABLE palindromes (
    word VARCHAR(100) CHECK (REVERSE(word) = word)
);

-- Safer version with named CHECK constraint on users2 table
CREATE TABLE users2 (
    username VARCHAR(20) NOT NULL,
    age INT,
    CONSTRAINT age_not_negative CHECK (age >= 0)
);

-- Another attempt at a palindrome table using a named CHECK constraint
CREATE TABLE palindromes2 (
    word VARCHAR(100),
    CONSTRAINT word_is_palindrome CHECK (REVERSE(word) = word)
);

-- Create a companies table with a composite UNIQUE constraint on name and address
CREATE TABLE companies (
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    CONSTRAINT name_address UNIQUE (name, address)
);

-- Create a houses table with a CHECK constraint to ensure sale price ≥ purchase price
CREATE TABLE houses (
    purchase_price INT NOT NULL,
    sale_price INT NOT NULL,
    CONSTRAINT sprice_gt_pprice CHECK (sale_price >= purchase_price)
);
