SELECT *
FROM   books b;

SELECT Reverse(Upper('Why does my cat look at me with such a hatered?'));

SELECT Replace(Concat('i', ' ', 'like', ' ', 'cats'), ' ', '-');

SELECT Replace(title, ' ', '->') AS title
FROM   books;

SELECT b.author_lname          AS forwards,
       Reverse(b.author_lname) AS backwards
FROM   books b;

SELECT Ucase(Concat_ws(' ', b.author_fname, b.author_lname)) AS FULL_NAME
FROM   books b;

SELECT Concat(b.title, ' was release in ', b.released_year) AS blurb
FROM   books b;

SELECT b.title,
       Char_length(b.title) AS 'chacter count'
FROM   books b;

SELECT Concat(Substr(title, 1, 10), '...')            AS 'short title',
       Concat_ws(',', b.author_lname, b.author_fname) AS author,
       Concat(b.stock_quantity, ' in stock')          AS quantity
FROM   books b;