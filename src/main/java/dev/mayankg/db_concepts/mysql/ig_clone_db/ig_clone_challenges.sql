-- 1. Find the 5 oldest users.
SELECT *
FROM users
ORDER BY created_at ASC
LIMIT 5;

-- 2. What day of the week do most users register on?
SELECT
    DAYNAME(created_at) AS day_of_week,
    COUNT(*) AS new_users
FROM users
GROUP BY day_of_week
ORDER BY new_users DESC
LIMIT 1;

-- 3. Find the users who have never posted a photo.
-- Option 1
SELECT *
FROM users
WHERE id NOT IN (
    SELECT user_id
    FROM photos
    GROUP BY user_id
);

-- Option 2
SELECT
    username
FROM users u
LEFT JOIN photos p ON u.id = p.user_id
WHERE p.user_id IS NULL;

-- 4. Which user has the most likes on a single photo?
SELECT
    p.id,
    u.username,
    p.image_url,
    lp.like_count
FROM photos p
RIGHT JOIN (
    SELECT
        photo_id,
        COUNT(*) AS like_count
    FROM likes
    GROUP BY photo_id
    ORDER BY like_count DESC
) AS lp ON p.id = lp.photo_id
INNER JOIN users u ON u.id = p.user_id
LIMIT 1;

-- 5.1. How many times does the average user post (excludes users who have never posted)?
SELECT
    COUNT(*) / COUNT(DISTINCT user_id) AS avg_post_per_user
FROM photos;

-- 5.2. How many times does the average user post (includes users who have never posted)?
SELECT
    (SELECT COUNT(*) FROM photos) / (SELECT COUNT(*) FROM users) AS avg_post_per_user;

-- 6. What are the top 5 most commonly used hashtags?
SELECT
    pt.tag_id,
    t.tag_name,
    COUNT(*) AS used
FROM photo_tags pt
LEFT JOIN tags t ON pt.tag_id = t.id
GROUP BY pt.tag_id, t.tag_name
ORDER BY used DESC
LIMIT 5;

-- 7. Find the users who have liked every single photo on the site.
SELECT
    l.user_id,
    u.username,
    COUNT(*) AS total
FROM users u
RIGHT JOIN likes l ON u.id = l.user_id
GROUP BY l.user_id, u.username
HAVING total = (SELECT COUNT(*) FROM photos);
