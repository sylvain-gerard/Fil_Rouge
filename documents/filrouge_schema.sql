

-- -----------------------------------------------------
-- Schema fil_rouge
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fil_rouge` DEFAULT CHARACTER SET utf8 ;
USE `fil_rouge` ;

-- -----------------------------------------------------
-- Table `fil_rouge`.`affaire`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`affaire` (
  `id_affaire` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `classee` BIT(1) NOT NULL,
  `date_cloture` DATE NULL DEFAULT NULL,
  `date_creation` DATE NULL DEFAULT NULL,
  `nom_affaire` VARCHAR(255) NULL DEFAULT NULL,
  `pieces_conviction` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_affaire`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fil_rouge`.`arme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`arme` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `infos_complementaire` VARCHAR(255) NULL DEFAULT NULL,
  `marque` VARCHAR(255) NULL DEFAULT NULL,
  `modele` VARCHAR(255) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `calibre` VARCHAR(100) NULL DEFAULT NULL,
  `numero_serie` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fil_rouge`.`affaire_arme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`affaire_arme` (
  `id_affaire` BIGINT(20) NOT NULL,
  `id_arme` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id_affaire`, `id_arme`),
  INDEX `FKfyrph57vbvokqn0psbttlnup3` (`id_arme` ASC),
  CONSTRAINT `FK9s0rmpso28th39goi4nxmkjy3`
    FOREIGN KEY (`id_affaire`)
    REFERENCES `fil_rouge`.`affaire` (`id_affaire`),
  CONSTRAINT `FKfyrph57vbvokqn0psbttlnup3`
    FOREIGN KEY (`id_arme`)
    REFERENCES `fil_rouge`.`arme` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fil_rouge`.`suspect`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`suspect` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(255) NULL DEFAULT NULL,
  `prenom` VARCHAR(255) NULL DEFAULT NULL,
  `adn` VARCHAR(255) NULL DEFAULT NULL,
  `adresse` VARCHAR(255) NULL DEFAULT NULL,
  `date_naissance` DATE NULL DEFAULT NULL,
  `infos_suspect` VARCHAR(255) NULL DEFAULT NULL,
  `matricule` VARCHAR(255) NULL DEFAULT NULL,
  `poids` DOUBLE NOT NULL,
  `sexe` VARCHAR(255) NULL DEFAULT NULL,
  `signes_particuliers` VARCHAR(255) NULL DEFAULT NULL,
  `taille` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fil_rouge`.`affaire_suspect`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`affaire_suspect` (
  `id_affaire` BIGINT(20) NOT NULL,
  `id_suspect` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id_affaire`, `id_suspect`),
  INDEX `FKlfpf55vwljt5aq21630h4cctd` (`id_suspect` ASC),
  CONSTRAINT `FKepmjiybpyyn8qrj414btahv5t`
    FOREIGN KEY (`id_affaire`)
    REFERENCES `fil_rouge`.`affaire` (`id_affaire`),
  CONSTRAINT `FKlfpf55vwljt5aq21630h4cctd`
    FOREIGN KEY (`id_suspect`)
    REFERENCES `fil_rouge`.`suspect` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fil_rouge`.`vehicule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`vehicule` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `infos_complementaire` VARCHAR(255) NULL DEFAULT NULL,
  `marque` VARCHAR(255) NULL DEFAULT NULL,
  `modele` VARCHAR(255) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `couleur_vehicule` VARCHAR(255) NULL DEFAULT NULL,
  `immatriculation` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fil_rouge`.`affaire_vehicule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`affaire_vehicule` (
  `id_affaire` BIGINT(20) NOT NULL,
  `id_vehicule` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id_affaire`, `id_vehicule`),
  INDEX `FKtgtdc7757nli7dd74dral7312` (`id_vehicule` ASC),
  CONSTRAINT `FKfbd3hg9v54ysk58x39f7ypah6`
    FOREIGN KEY (`id_affaire`)
    REFERENCES `fil_rouge`.`affaire` (`id_affaire`),
  CONSTRAINT `FKtgtdc7757nli7dd74dral7312`
    FOREIGN KEY (`id_vehicule`)
    REFERENCES `fil_rouge`.`vehicule` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fil_rouge`.`utilisateur`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fil_rouge`.`utilisateur` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(255) NULL DEFAULT NULL,
  `prenom` VARCHAR(255) NULL DEFAULT NULL,
  `habilitation` VARCHAR(255) NULL DEFAULT NULL,
  `matricule` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


