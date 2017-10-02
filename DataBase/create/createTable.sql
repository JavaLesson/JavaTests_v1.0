-- MySQL Workbench Synchronization
-- Generated: 2017-09-29 11:09
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: User

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `JavaTests` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `JavaTests`.`User` (
  `userId` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(100) NOT NULL,
  `lastName` VARCHAR(100) NOT NULL,
  `login` VARCHAR(100) NOT NULL,
  `password` int(11) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Question` (
  `questionId` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(1000) NOT NULL,
  `testId` INT(11) NOT NULL,
  `topicId` INT(11) NOT NULL,
  PRIMARY KEY (`questionId`, `testId`, `topicId`),
  UNIQUE INDEX `questionId_UNIQUE` (`questionId` ASC),
  INDEX `idx_question_test` (`testId` ASC),
  INDEX `idx_question_topic` (`topicId` ASC),
  CONSTRAINT `fk_question_test`
    FOREIGN KEY (`testId` )
    REFERENCES `JavaTests`.`Test` (`testId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_topic`
    FOREIGN KEY (`topicId`)
    REFERENCES `JavaTests`.`Topic` (`topicId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Answer` (
  `answerId` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(1000) NOT NULL,
  `correct` TINYINT(1) NOT NULL,
  `questionId` INT(11) NOT NULL,
  PRIMARY KEY (`answerId`),
  UNIQUE INDEX `answerId_UNIQUE` (`answerId` ASC),
  INDEX `idx_answer_question` (`questionId` ASC),
  CONSTRAINT `fk_answer`
    FOREIGN KEY (`questionId`)
    REFERENCES `JavaTests`.`Question` (`questionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Literature` (
  `literatureId` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(1000) NOT NULL,
  `questionId` INT(11) NOT NULL,
  `testId` INT(11) NOT NULL,
  `topicId` INT(11) NOT NULL,
  PRIMARY KEY (`literatureId`),
  UNIQUE INDEX `literatureId_UNIQUE` (`literatureId` ASC),
  INDEX `idx_literature_question` (`questionId` ASC),
  INDEX `idx_literature_test` (`testId` ASC),
  INDEX `idx_literature_topic` (`topicId` ASC),
  CONSTRAINT `fk_literature_question`
    FOREIGN KEY (`questionId`)
    REFERENCES `JavaTests`.`Question` (`questionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_literature_test`
    FOREIGN KEY (`testId`)
    REFERENCES `JavaTests`.`Test` (`testId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_literature_topic`
    FOREIGN KEY (`topicId`)
    REFERENCES `JavaTests`.`Topic` (`topicId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Link` (
  `linkId` INT(11) NOT NULL AUTO_INCREMENT,
  `link` VARCHAR(100) NULL DEFAULT NULL,
  `literatureId` INT(11) NOT NULL,
  `questionId` INT(11) NOT NULL,
  `testId` INT(11) NOT NULL,
  `topicId` INT(11) NOT NULL,
  PRIMARY KEY (`linkId`),
  UNIQUE INDEX `linksId_UNIQUE` (`linkId` ASC),
  INDEX `idx_link_literature` (`literatureId` ASC),
  INDEX `idx_link_question` (`questionId` ASC),
  INDEX `idx_link_test` (`testId` ASC),
  INDEX `idx_link_topic` (`topicId` ASC),
  CONSTRAINT `fk_link_literature`
    FOREIGN KEY (`literatureId`)
    REFERENCES `JavaTests`.`Literature` (`literatureId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_link_question`
    FOREIGN KEY (`questionId`)
    REFERENCES `JavaTests`.`Question` (`questionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_link_test`
    FOREIGN KEY (`testId`)
    REFERENCES `JavaTests`.`Test` (`testId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_link_topic`
    FOREIGN KEY (`topicId`)
    REFERENCES `JavaTests`.`Topic` (`topicId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Topic` (
  `topicId` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`topicId`),
  UNIQUE INDEX `topicId_UNIQUE` (`topicId` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Test` (
  `testId` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `topicId` INT(11) NOT NULL,
  PRIMARY KEY (`testId`, `topicId`),
  UNIQUE INDEX `testId_UNIQUE` (`testId` ASC),
  INDEX `idx_test_topic` (`topicId` ASC),
  CONSTRAINT `fk_test`
    FOREIGN KEY (`topicId`)
    REFERENCES `JavaTests`.`Topic` (`topicId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Statistic` (
  `statisticId` INT(11) NOT NULL AUTO_INCREMENT,
  `correct` TINYINT(1) NOT NULL,
  `date` DATE not null,
  `userId` INT(11) NOT NULL,
  `questionId` INT(11) NOT NULL,
  `testId` INT(11) NOT NULL,
  `topicId` INT(11) NOT NULL,
  PRIMARY KEY (`statisticId`),
  UNIQUE INDEX `userQuestionStatisticId_UNIQUE` (`statisticId` ASC),
  INDEX `idx_userQuestionStatistic_User` (`userId` ASC),
  INDEX `idx_userQuestionStatistic_question` (`questionId` ASC),
  INDEX `idx_userQuestionStatistic_test` (`testId` ASC),
  INDEX `idx_userQuestionStatistic_topic` (`topicId` ASC),
  CONSTRAINT `fk_userQuestionStatistic_user`
    FOREIGN KEY (`userId`)
    REFERENCES `JavaTests`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userQuestionStatistic_question`
    FOREIGN KEY (`questionId`)
    REFERENCES `JavaTests`.`Question` (`questionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_userQuestionStatistic_test`
    FOREIGN KEY (`testId`)
    REFERENCES `JavaTest`.`Test` (`testId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_userQuestionStatistic_topic`
    FOREIGN KEY (`topicId`)
    REFERENCES `JavaTest`.`Topic` (`topicId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

create table if not exists `JavaTests`.`TaskTracker`(
	`taskTrackerId` INT(11) NOT NULL AUTO_INCREMENT,
    `startDate` Date not null,
    `endDate` Date NOT NULL,
    `compleat` TINYINT(1) not null,
    `userId` int(11) not null,
    primary key (`taskTrackerId`),
    index `idx_taskTracker_user`(`userId` asc),
    constraint `fk_taskTracker_user` 
    FOREIGN KEY (`userId`)
    REFERENCES `JavaTests`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION    
) 
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
