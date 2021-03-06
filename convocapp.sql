-- MySQL Script generated by MySQL Workbench
-- 11/16/14 00:39:52
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema convocapp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema convocapp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `convocapp` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `convocapp` ;

-- -----------------------------------------------------
-- Table `convocapp`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`roles` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `convocapp`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`user` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `identification` VARCHAR(45) NOT NULL,
  `username` VARCHAR(16) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `email` VARCHAR(255) NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NULL,
  `phone` VARCHAR(20) NULL,
  `cellphone` VARCHAR(20) NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`, `roles_id`),
  INDEX `fk_user_roles1_idx` (`roles_id` ASC),
  CONSTRAINT `fk_user_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `convocapp`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `convocapp`.`state`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`state` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`state` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `code` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `convocapp`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`city` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `state_id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_city_state1_idx` (`state_id` ASC),
  CONSTRAINT `fk_city_state1`
    FOREIGN KEY (`state_id`)
    REFERENCES `convocapp`.`state` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `convocapp`.`aplicant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`aplicant` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`aplicant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `identification` VARCHAR(45) NOT NULL,
  `identification_type` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `birthdate` TIMESTAMP NULL,
  `sex` VARCHAR(10) NOT NULL,
  `address` VARCHAR(255) NULL,
  `phone` VARCHAR(20) NULL,
  `cellphone` VARCHAR(20) NULL,
  `company` VARCHAR(255) NOT NULL,
  `company_city_id` INT NULL,
  `company_address` VARCHAR(255) NULL,
  `company_phone` VARCHAR(20) NULL,
  `working_time` VARCHAR(45) NOT NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  `city_id` INT NOT NULL,
  `created_by_id` INT NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `totalScore` FLOAT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_applicant_user1_idx` (`created_by_id` ASC),
  INDEX `fk_applicant_city1_idx` (`city_id` ASC),
  CONSTRAINT `fk_applicant_user1`
    FOREIGN KEY (`created_by_id`)
    REFERENCES `convocapp`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_applicant_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `convocapp`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `convocapp`.`convocatory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`convocatory` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`convocatory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` TEXT NULL,
  `start_date` TIMESTAMP NULL,
  `end_date` TIMESTAMP NULL,
  `publishing_date` TIMESTAMP NULL,
  `active` INT(1) NOT NULL DEFAULT 1,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `convocapp`.`user_in_convocatory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`user_in_convocatory` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`user_in_convocatory` (
  `user_id` INT NOT NULL,
  `convocatory_id` INT NOT NULL,
  `active` TINYINT(1) NULL,
  PRIMARY KEY (`user_id`, `convocatory_id`, `active`),
  INDEX `fk_user_has_convocatory_convocatory1_idx` (`convocatory_id` ASC),
  INDEX `fk_user_has_convocatory_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_convocatory_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `convocapp`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_convocatory_convocatory1`
    FOREIGN KEY (`convocatory_id`)
    REFERENCES `convocapp`.`convocatory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `convocapp`.`language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`language` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`language` (
  `id_language` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `read score` FLOAT NULL,
  `write score` FLOAT NULL,
  `talk score` FLOAT NULL,
  `score` FLOAT NULL,
  PRIMARY KEY (`id_language`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `convocapp`.`TotalScore`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`TotalScore` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`TotalScore` (
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `convocapp`.`aplicant_has_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`aplicant_has_language` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`aplicant_has_language` (
  `aplicant_id` INT NOT NULL,
  `language_id_language` INT NOT NULL,
  `max_score` FLOAT NULL,
  PRIMARY KEY (`aplicant_id`, `language_id_language`),
  INDEX `fk_aplicant_has_language_language1_idx` (`language_id_language` ASC),
  INDEX `fk_aplicant_has_language_aplicant1_idx` (`aplicant_id` ASC),
  CONSTRAINT `fk_aplicant_has_language_aplicant1`
    FOREIGN KEY (`aplicant_id`)
    REFERENCES `convocapp`.`aplicant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aplicant_has_language_language1`
    FOREIGN KEY (`language_id_language`)
    REFERENCES `convocapp`.`language` (`id_language`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `convocapp`.`tic_trraining_experience`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`tic_trraining_experience` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`tic_trraining_experience` (
  `id` INT NOT NULL,
  `exp_students` FLOAT NULL,
  `exp_teachers` FLOAT NULL,
  `exp_trainers` FLOAT NULL,
  `score` FLOAT NULL,
  `aplicant_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tic_trraining_experience_aplicant1_idx` (`aplicant_id` ASC),
  CONSTRAINT `fk_tic_trraining_experience_aplicant1`
    FOREIGN KEY (`aplicant_id`)
    REFERENCES `convocapp`.`aplicant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `convocapp`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`course` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`course` (
  `id` INT NOT NULL,
  `score` FLOAT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `convocapp`.`aplicant_has_course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`aplicant_has_course` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`aplicant_has_course` (
  `aplicant_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  `max_score` FLOAT NULL,
  PRIMARY KEY (`aplicant_id`, `course_id`),
  INDEX `fk_aplicant_has_course_course1_idx` (`course_id` ASC),
  INDEX `fk_aplicant_has_course_aplicant1_idx` (`aplicant_id` ASC),
  CONSTRAINT `fk_aplicant_has_course_aplicant1`
    FOREIGN KEY (`aplicant_id`)
    REFERENCES `convocapp`.`aplicant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aplicant_has_course_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `convocapp`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `convocapp`.`degree`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`degree` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`degree` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `score` FLOAT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `convocapp`.`aplicant_has_degree`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`aplicant_has_degree` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`aplicant_has_degree` (
  `aplicant_id` INT NOT NULL,
  `degree_id` INT NOT NULL,
  `max_score` VARCHAR(45) NULL,
  PRIMARY KEY (`aplicant_id`, `degree_id`),
  INDEX `fk_aplicant_has_degree_degree1_idx` (`degree_id` ASC),
  INDEX `fk_aplicant_has_degree_aplicant1_idx` (`aplicant_id` ASC),
  CONSTRAINT `fk_aplicant_has_degree_aplicant1`
    FOREIGN KEY (`aplicant_id`)
    REFERENCES `convocapp`.`aplicant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aplicant_has_degree_degree1`
    FOREIGN KEY (`degree_id`)
    REFERENCES `convocapp`.`degree` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `convocapp`.`specific_knowledge`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `convocapp`.`specific_knowledge` ;

CREATE TABLE IF NOT EXISTS `convocapp`.`specific_knowledge` (
  `id` INT NOT NULL,
  `informatic` FLOAT NULL,
  `web` FLOAT NULL,
  `multimedia` FLOAT NULL,
  `digital_contents` FLOAT NULL,
  `books_development` FLOAT NULL,
  `tic_projects` FLOAT NULL,
  `competences` FLOAT NULL,
  `score` FLOAT NULL,
  `aplicant_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_specific_knowledge_aplicant1_idx` (`aplicant_id` ASC),
  CONSTRAINT `fk_specific_knowledge_aplicant1`
    FOREIGN KEY (`aplicant_id`)
    REFERENCES `convocapp`.`aplicant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;