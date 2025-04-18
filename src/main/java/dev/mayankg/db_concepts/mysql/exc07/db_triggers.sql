-- MySQL Triggers Basic Syntax
DELIMITER $$

CREATE TRIGGER trigger_name
     trigger_time trigger_event ON table_name FOR EACH ROW
     BEGIN
     END;
$$

DELIMITER ;

-- show all triggers
SHOW TRIGGERS;

-- drop trigger
DROP TRIGGER IF EXISTS trigger_name;


-- MySQL Trigger Example1
DELIMITER $$

CREATE TRIGGER must_be_adult
     BEFORE INSERT ON users FOR EACH ROW
     BEGIN
          IF NEW.age < 18
          THEN
              SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Must be an adult!';
          END IF;
     END;
$$

DELIMITER ;


-- MySQL Trigger Example2
DELIMITER $$

CREATE TRIGGER example_cannot_follow_self
     BEFORE INSERT ON follows FOR EACH ROW
     BEGIN
          IF NEW.follower_id = NEW.followee_id
          THEN
               SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Cannot follow yourself, silly';
          END IF;
     END;
$$

DELIMITER ;

-- MySQL Trigger Example3
DELIMITER $$

CREATE TRIGGER create_unfollow
    AFTER DELETE ON follows FOR EACH ROW
BEGIN
    INSERT INTO unfollows
    SET follower_id = OLD.follower_id,
        followee_id = OLD.followee_id;
END$$

DELIMITER ;


