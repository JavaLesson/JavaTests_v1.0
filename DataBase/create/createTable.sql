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
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Question` (
  `questionId` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `testId` INT(11) NOT NULL,
  `topicId` INT(11) NOT NULL,
  PRIMARY KEY (`questionId`, `testId`, `topicId`),
  UNIQUE INDEX `questionId_UNIQUE` (`questionId` ASC),
  INDEX `fk_Question_test1_idx` (`testId` ASC, `topicId` ASC),
  CONSTRAINT `fk_Question_test1`
    FOREIGN KEY (`testId` , `topicId`)
    REFERENCES `JavaTests`.`Test` (`testId` , `topicId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Answer` (
  `answerId` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `correct` TINYINT(1) NOT NULL,
  `questionId` INT(11) NOT NULL,
  PRIMARY KEY (`answerId`, `questionId`),
  UNIQUE INDEX `answerId_UNIQUE` (`answerId` ASC),
  INDEX `fk_Answer_Question1_idx` (`questionId` ASC),
  CONSTRAINT `fk_Answer_Question1`
    FOREIGN KEY (`questionId`)
    REFERENCES `JavaTests`.`Question` (`questionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Literature` (
  `literatureId` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `questionId` INT(11) NOT NULL,
  `testId` INT(11) NOT NULL,
  `topicId` INT(11) NOT NULL,
  PRIMARY KEY (`literatureId`, `questionId`, `testId`, `topicId`),
  UNIQUE INDEX `literatureId_UNIQUE` (`literatureId` ASC),
  INDEX `fk_Literature_Question1_idx` (`questionId` ASC),
  INDEX `fk_Literature_test1_idx` (`testId` ASC),
  INDEX `fk_Literature_topic1_idx` (`topicId` ASC),
  CONSTRAINT `fk_Literature_Question1`
    FOREIGN KEY (`questionId`)
    REFERENCES `JavaTests`.`Question` (`questionId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Literature_test1`
    FOREIGN KEY (`testId`)
    REFERENCES `JavaTests`.`Test` (`testId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Literature_topic1`
    FOREIGN KEY (`topicId`)
    REFERENCES `JavaTests`.`Topic` (`topicId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Link` (
  `linkId` INT(11) NOT NULL AUTO_INCREMENT,
  `link` VARCHAR(45) NULL DEFAULT NULL,
  `literatureId` INT(11) NOT NULL,
  `questionId` INT(11) NOT NULL,
  `testId` INT(11) NOT NULL,
  `topicId` INT(11) NOT NULL,
  PRIMARY KEY (`linkId`, `literatureId`, `questionId`, `testId`, `topicId`),
  UNIQUE INDEX `linksId_UNIQUE` (`linkId` ASC),
  INDEX `fk_Link_Literature1_idx` (`literatureId` ASC, `questionId` ASC, `testId` ASC, `topicId` ASC),
  CONSTRAINT `fk_Link_Literature1`
    FOREIGN KEY (`literatureId` , `questionId` , `testId` , `topicId`)
    REFERENCES `JavaTests`.`Literature` (`literatureId` , `questionId` , `testId` , `topicId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Topic` (
  `topicId` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
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
  INDEX `fk_test_topic1_idx` (`topicId` ASC),
  CONSTRAINT `fk_test_topic1`
    FOREIGN KEY (`topicId`)
    REFERENCES `JavaTests`.`Topic` (`topicId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `JavaTests`.`Statistic` (
  `statisticId` INT(11) NOT NULL AUTO_INCREMENT,
  `correct` TINYINT(1) NOT NULL,
  `userId` INT(11) NOT NULL,
  `questionId` INT(11) NOT NULL,
  `testId` INT(11) NOT NULL,
  `topicId` INT(11) NOT NULL,
  PRIMARY KEY (`statisticId`, `userId`, `questionId`, `testId`, `topicId`),
  UNIQUE INDEX `userQuestionStatisticId_UNIQUE` (`statisticId` ASC),
  INDEX `fk_UserQuestionStatistic_User_idx` (`userId` ASC),
  INDEX `fk_UserQuestionStatistic_Question1_idx` (`questionId` ASC, `testId` ASC, `topicId` ASC),
  CONSTRAINT `fk_UserQuestionStatistic_User`
    FOREIGN KEY (`userId`)
    REFERENCES `JavaTests`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UserQuestionStatistic_Question1`
    FOREIGN KEY (`questionId` , `testId` , `topicId`)
    REFERENCES `JavaTests`.`Question` (`questionId` , `testId` , `topicId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
