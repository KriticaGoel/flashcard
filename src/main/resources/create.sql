CREATE TABLE `flashcard`.`category` (
                                        `category_id` INT NOT NULL,
                                        `Category_name` VARCHAR(95) NOT NULL,
                                        UNIQUE INDEX `Category_name_UNIQUE` (`Category_name` ASC) VISIBLE,
                                        PRIMARY KEY (`category_id`));
CREATE TABLE `flashcard`.`topic` (
                                     `topic_id` INT NOT NULL,
                                     `topic_name` VARCHAR(45) NOT NULL,
                                     PRIMARY KEY (`topic_id`),
                                     UNIQUE INDEX `topic_name_UNIQUE` (`topic_name` ASC) VISIBLE);

CREATE TABLE `flashcard`.`revision` (
                                        `Revision_id` INT NOT NULL,
                                        `category_id` INT NOT NULL,
                                        `Topic_id` INT NOT NULL,
                                        `Question` VARCHAR(255) NOT NULL,
                                        `Hint1` VARCHAR(255) NULL,
                                        `Hint2` VARCHAR(255) NULL,
                                        `Hint3` VARCHAR(255) NULL,
                                        PRIMARY KEY (`Revision_id`),
                                        UNIQUE INDEX `Question_UNIQUE` (`Question` ASC) VISIBLE);