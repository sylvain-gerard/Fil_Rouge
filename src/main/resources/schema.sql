-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `filrouge` DEFAULT CHARACTER SET utf8 ;
USE `filrouge` ;

-- -----------------------------------------------------
-- Table `filrouge`.`suspects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `filrouge`.`suspects` (
  `id_suspect` INT NOT NULL,
  `nom_suspect` VARCHAR(45) NULL,
  `prenom_suspect` VARCHAR(45) NULL,
  `adresse` VARCHAR(45) NULL,
  `date_naissance` VARCHAR(45) NULL,
  `taile` INT NULL,
  `poids` INT NULL,
  `couleur_peau` VARCHAR(45) NULL,
  `couleur_yeux` VARCHAR(45) NULL,
  `signes_particuliers` VARCHAR(45) NULL,
  `adn` VARCHAR(45) NULL,
  PRIMARY KEY (`id_suspect`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filrouge`.`affaires`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `filrouge`.`affaires` (
  `id_affaire` INT NOT NULL,
  `date_creation` VARCHAR(45) NULL,
  `date_cloture` VARCHAR(45) NULL,
  `pieces_conviction` VARCHAR(45) NULL,
  `classee` TINYINT NULL,
  PRIMARY KEY (`id_affaire`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filrouge`.`armes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `filrouge`.`armes` (
  `id_arme` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  `marque_arme` VARCHAR(45) NULL,
  `modele_arme` VARCHAR(45) NULL,
  `calibre` VARCHAR(45) NULL,
  `numero_serie` VARCHAR(45) NULL,
  PRIMARY KEY (`id_arme`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filrouge`.`vehicules`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `filrouge`.`vehicules` (
  `id_vehicules` INT NOT NULL,
  `marque_vehicule` VARCHAR(45) NULL,
  `modele_vehicule` VARCHAR(45) NULL,
  `immatriculation` VARCHAR(45) NULL,
  `couleur_vehicule` VARCHAR(45) NULL,
  PRIMARY KEY (`id_vehicules`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filrouge`.`utilisateurs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `filrouge`.`utilisateurs` (
  `id_utilisateurs` INT NULL,
  `nom_agent` VARCHAR(45) NULL,
  `prenom_agent` VARCHAR(45) NULL,
  `admin` TINYINT NULL,
  `creer` TINYINT NULL,
  `modifier` TINYINT NULL,
  `supprimer` TINYINT NULL,
  PRIMARY KEY (`id_utilisateurs`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filrouge`.`vehicules_has_affaires`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `filrouge`.`vehicules_has_affaires` (
  `vehicules_id_vehicules` INT NOT NULL,
  `affaires_id_affaire` INT NOT NULL,
  PRIMARY KEY (`vehicules_id_vehicules`, `affaires_id_affaire`),
  INDEX `fk_vehicules_has_affaires_affaires1_idx` (`affaires_id_affaire` ASC),
  INDEX `fk_vehicules_has_affaires_vehicules_idx` (`vehicules_id_vehicules` ASC),
  CONSTRAINT `fk_vehicules_has_affaires_vehicules`
    FOREIGN KEY (`vehicules_id_vehicules`)
    REFERENCES `filrouge`.`vehicules` (`id_vehicules`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicules_has_affaires_affaires1`
    FOREIGN KEY (`affaires_id_affaire`)
    REFERENCES `filrouge`.`affaires` (`id_affaire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filrouge`.`armes_has_affaires`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `filrouge`.`armes_has_affaires` (
  `armes_id_arme` INT NOT NULL,
  `affaires_id_affaire` INT NOT NULL,
  PRIMARY KEY (`armes_id_arme`, `affaires_id_affaire`),
  INDEX `fk_armes_has_affaires_affaires1_idx` (`affaires_id_affaire` ASC),
  INDEX `fk_armes_has_affaires_armes1_idx` (`armes_id_arme` ASC),
  CONSTRAINT `fk_armes_has_affaires_armes1`
    FOREIGN KEY (`armes_id_arme`)
    REFERENCES `filrouge`.`armes` (`id_arme`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_armes_has_affaires_affaires1`
    FOREIGN KEY (`affaires_id_affaire`)
    REFERENCES `filrouge`.`affaires` (`id_affaire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `filrouge`.`suspects_has_affaires`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `filrouge`.`suspects_has_affaires` (
  `suspects_id_suspect` INT NOT NULL,
  `affaires_id_affaire` INT NOT NULL,
  PRIMARY KEY (`suspects_id_suspect`, `affaires_id_affaire`),
  INDEX `fk_suspects_has_affaires_affaires1_idx` (`affaires_id_affaire` ASC),
  INDEX `fk_suspects_has_affaires_suspects1_idx` (`suspects_id_suspect` ASC),
  CONSTRAINT `fk_suspects_has_affaires_suspects1`
    FOREIGN KEY (`suspects_id_suspect`)
    REFERENCES `filrouge`.`suspects` (`id_suspect`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_suspects_has_affaires_affaires1`
    FOREIGN KEY (`affaires_id_affaire`)
    REFERENCES `filrouge`.`affaires` (`id_affaire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
