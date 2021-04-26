-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema movie
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema movie
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `movie` DEFAULT CHARACTER SET utf8 ;
USE `movie` ;

-- -----------------------------------------------------
-- Table `movie`.`DIRECTOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie`.`DIRECTOR` (
  `DNAME` VARCHAR(45) NULL,
  `DNUM` INT NOT NULL,
  PRIMARY KEY (`DNUM`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie`.`PRODUCER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie`.`PRODUCER` (
  `PNAME` VARCHAR(45) NULL,
  `PNUM` INT NOT NULL,
  PRIMARY KEY (`PNUM`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie`.`ACTOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie`.`ACTOR` (
  `NAME` VARCHAR(45) NULL,
  `ANUM` INT NOT NULL,
  `DIRECTOR_DNUM` INT NULL,
  `PRODUCER_PNUM` INT NULL,
  PRIMARY KEY (`ANUM`),
  INDEX `fk_ACTOR_DIRECTOR1_idx` (`DIRECTOR_DNUM` ASC) VISIBLE,
  INDEX `fk_ACTOR_PRODUCER1_idx` (`PRODUCER_PNUM` ASC) VISIBLE,
  UNIQUE INDEX `PRODUCER_PNUM_UNIQUE` (`PRODUCER_PNUM` ASC) VISIBLE,
  UNIQUE INDEX `DIRECTOR_DNUM_UNIQUE` (`DIRECTOR_DNUM` ASC) VISIBLE,
  CONSTRAINT `fk_ACTOR_DIRECTOR1`
    FOREIGN KEY (`DIRECTOR_DNUM`)
    REFERENCES `movie`.`DIRECTOR` (`DNUM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ACTOR_PRODUCER1`
    FOREIGN KEY (`PRODUCER_PNUM`)
    REFERENCES `movie`.`PRODUCER` (`PNUM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie`.`MOVIE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie`.`MOVIE` (
  `MNAME` VARCHAR(45) NULL,
  `MNUM` INT NOT NULL,
  `film_distributor` VARCHAR(45) NULL,
  `DIRECTOR_DNUM` INT NOT NULL,
  `PRODUCER_PNUM` INT NOT NULL,
  PRIMARY KEY (`MNUM`),
  INDEX `fk_MOVIE_DIRECTOR1_idx` (`DIRECTOR_DNUM` ASC) VISIBLE,
  INDEX `fk_MOVIE_PRODUCER1_idx` (`PRODUCER_PNUM` ASC) VISIBLE,
  CONSTRAINT `fk_MOVIE_DIRECTOR1`
    FOREIGN KEY (`DIRECTOR_DNUM`)
    REFERENCES `movie`.`DIRECTOR` (`DNUM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MOVIE_PRODUCER1`
    FOREIGN KEY (`PRODUCER_PNUM`)
    REFERENCES `movie`.`PRODUCER` (`PNUM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie`.`PERFORMS_IN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie`.`PERFORMS_IN` (
  `ACTOR_ANUM` INT NOT NULL,
  `MOVIE_MNUM` INT NOT NULL,
  INDEX `fk_ACTOR_has_MOVIE_MOVIE1_idx` (`MOVIE_MNUM` ASC) VISIBLE,
  INDEX `fk_ACTOR_has_MOVIE_ACTOR1_idx` (`ACTOR_ANUM` ASC) VISIBLE,
  CONSTRAINT `fk_ACTOR_has_MOVIE_ACTOR1`
    FOREIGN KEY (`ACTOR_ANUM`)
    REFERENCES `movie`.`ACTOR` (`ANUM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ACTOR_has_MOVIE_MOVIE1`
    FOREIGN KEY (`MOVIE_MNUM`)
    REFERENCES `movie`.`MOVIE` (`MNUM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie`.`LEAD_ROLE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie`.`LEAD_ROLE` (
  `ACTOR_ANUM` INT NOT NULL,
  `MOVIE_MNUM` INT NULL,
  INDEX `fk_ACTOR_has_MOVIE_MOVIE2_idx` (`MOVIE_MNUM` ASC) VISIBLE,
  INDEX `fk_ACTOR_has_MOVIE_ACTOR2_idx` (`ACTOR_ANUM` ASC) VISIBLE,
  CONSTRAINT `fk_ACTOR_has_MOVIE_ACTOR2`
    FOREIGN KEY (`ACTOR_ANUM`)
    REFERENCES `movie`.`ACTOR` (`ANUM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ACTOR_has_MOVIE_MOVIE2`
    FOREIGN KEY (`MOVIE_MNUM`)
    REFERENCES `movie`.`MOVIE` (`MNUM`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
