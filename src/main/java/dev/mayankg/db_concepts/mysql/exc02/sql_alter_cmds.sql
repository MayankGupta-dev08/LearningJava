-- Add a new column 'phone' to companies table
ALTER TABLE companies
ADD COLUMN phone VARCHAR(15);

-- Add a NOT NULL column 'employee_count' with a default value
ALTER TABLE companies
ADD COLUMN employee_count INT NOT NULL DEFAULT 1;

-- Remove the 'phone' column from companies
ALTER TABLE companies
DROP COLUMN phone;

-- Rename the 'companies' table to 'suppliers'
RENAME TABLE companies TO suppliers;

-- Rename it back to 'companies'
ALTER TABLE suppliers RENAME TO companies;

-- Rename column 'name' to 'company_name'
ALTER TABLE companies
RENAME COLUMN name TO company_name;

-- Modify column 'company_name' to have a new default value and length
ALTER TABLE companies
MODIFY company_name VARCHAR(100) DEFAULT 'unknown';

-- Rename column 'business' to 'biz_name' and change its data type
ALTER TABLE suppliers
CHANGE business biz_name VARCHAR(50);

-- Add a CHECK constraint to ensure purchase_price is non-negative
ALTER TABLE houses 
ADD CONSTRAINT positive_pprice CHECK (purchase_price >= 0);

-- Drop the CHECK constraint named 'positive_pprice'
ALTER TABLE houses 
DROP CONSTRAINT positive_pprice;
