-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema fil_rouge
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fil_rouge
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fil_rouge` DEFAULT CHARACTER SET utf8 ;
USE `fil_rouge` ;

-- -----------------------------------------------------
-- Table `fil_rouge`.`suspects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`suspects` (
  `id_suspect` INT NOT NULL AUTO_INCREMENT,
  `nom_suspect` VARCHAR(45) NULL,
  `prenom_suspect` VARCHAR(45) NULL,
  `sexe` VARCHAR(45) NULL,
  `date_naissance` VARCHAR(45) NULL,
  `taille` INT NULL,
  `poids` INT NULL,
  `adresse` VARCHAR(45) NULL,
  `signes_particuliers` VARCHAR(45) NULL,
  `adn` VARCHAR(45) NULL,
  `photos` VARCHAR(45) NULL,
  `empreintes` VARCHAR(45) NULL,
  PRIMARY KEY (`id_suspect`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fil_rouge`.`affaires`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`affaires` (
  `id_affaire` INT NOT NULL AUTO_INCREMENT,
  `nom_affaire` VARCHAR(45) NULL,
  `date_creation` VARCHAR(45) NULL,
  `date_cloture` VARCHAR(45) NULL,
  `infos_affaire` VARCHAR(45) NULL,
  `classee` TINYINT NULL,
  `vehicules` VARCHAR(45) NULL,
  `suspects` VARCHAR(45) NULL,
  `armes` VARCHAR(45) NULL,
  PRIMARY KEY (`id_affaire`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fil_rouge`.`armes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`armes` (
  `id_arme` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  `marque_arme` VARCHAR(45) NULL,
  `modele_arme` VARCHAR(45) NULL,
  `calibre` VARCHAR(45) NULL,
  `numero_serie` VARCHAR(45) NULL,
  PRIMARY KEY (`id_arme`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fil_rouge`.`vehicules`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`vehicules` (
  `id_vehicules` INT NOT NULL AUTO_INCREMENT,
  `marque_vehicule` VARCHAR(45) NULL,
  `modele_vehicule` VARCHAR(45) NULL,
  `immatriculation` VARCHAR(45) NULL,
  `couleur_vehicule` VARCHAR(45) NULL,
  PRIMARY KEY (`id_vehicules`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fil_rouge`.`utilisateur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`utilisateur` (
  `id_utilisateur` INT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `prenom` VARCHAR(45) NULL,
  `matricule` VARCHAR(45) NULL,
  `habilitation` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id_utilisateur`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fil_rouge`.`armes_has_affaires`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`armes_has_affaires` (
  `armes_id_arme` INT NOT NULL,
  `affaires_id_affaire` INT NOT NULL,
  PRIMARY KEY (`armes_id_arme`, `affaires_id_affaire`),
  INDEX `fk_armes_has_affaires_affaires1_idx` (`affaires_id_affaire` ASC),
  INDEX `fk_armes_has_affaires_armes_idx` (`armes_id_arme` ASC),
  CONSTRAINT `fk_armes_has_affaires_armes`
    FOREIGN KEY (`armes_id_arme`)
    REFERENCES `fil_rouge`.`armes` (`id_arme`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_armes_has_affaires_affaires1`
    FOREIGN KEY (`affaires_id_affaire`)
    REFERENCES `fil_rouge`.`affaires` (`id_affaire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fil_rouge`.`suspects_has_affaires`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`suspects_has_affaires` (
  `suspects_id_suspect` INT NOT NULL,
  `affaires_id_affaire` INT NOT NULL,
  PRIMARY KEY (`suspects_id_suspect`, `affaires_id_affaire`),
  INDEX `fk_suspects_has_affaires_affaires1_idx` (`affaires_id_affaire` ASC),
  INDEX `fk_suspects_has_affaires_suspects1_idx` (`suspects_id_suspect` ASC),
  CONSTRAINT `fk_suspects_has_affaires_suspects1`
    FOREIGN KEY (`suspects_id_suspect`)
    REFERENCES `fil_rouge`.`suspects` (`id_suspect`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_suspects_has_affaires_affaires1`
    FOREIGN KEY (`affaires_id_affaire`)
    REFERENCES `fil_rouge`.`affaires` (`id_affaire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fil_rouge`.`vehicules_has_affaires`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`vehicules_has_affaires` (
  `vehicules_id_vehicules` INT NOT NULL,
  `affaires_id_affaire` INT NOT NULL,
  PRIMARY KEY (`vehicules_id_vehicules`, `affaires_id_affaire`),
  INDEX `fk_vehicules_has_affaires_affaires1_idx` (`affaires_id_affaire` ASC),
  INDEX `fk_vehicules_has_affaires_vehicules1_idx` (`vehicules_id_vehicules` ASC),
  CONSTRAINT `fk_vehicules_has_affaires_vehicules1`
    FOREIGN KEY (`vehicules_id_vehicules`)
    REFERENCES `fil_rouge`.`vehicules` (`id_vehicules`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicules_has_affaires_affaires1`
    FOREIGN KEY (`affaires_id_affaire`)
    REFERENCES `fil_rouge`.`affaires` (`id_affaire`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
