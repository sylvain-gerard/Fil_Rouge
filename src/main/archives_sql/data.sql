
INSERT INTO `fil_rouge`.`utilisateur` (`nom`, `prenom`, `matricule`, `habilitation`, `password`) VALUES ('Gallard', 'Fabrice', 'GF1', 'ADMIN', 'AZER');
INSERT INTO `fil_rouge`.`utilisateur` (`nom`, `prenom`, `matricule`, `habilitation`, `password`) VALUES ('Balmine', 'Davy', 'BD2', 'SERGENT', 'QSDF');
INSERT INTO `fil_rouge`.`utilisateur` (`nom`, `prenom`, `matricule`, `habilitation`, `password`) VALUES ('Genre', 'Didier', 'GD3', 'INSPECTEUR', 'WXCV');
INSERT INTO `fil_rouge`.`utilisateur` (`nom`, `prenom`, `matricule`, `habilitation`, `password`) VALUES ('Gerard', 'Sylvain', 'GS4', 'AGENT', '1234');

INSERT INTO `fil_rouge`.`arme` (`marque`, `modele`, `type`, `calibre`, `numero_serie`) VALUES ('FN', 'FAMAS', 'Fusil d\'assaut', '5.56', '8K345876M13');
INSERT INTO `fil_rouge`.`arme` (`marque`, `modele`, `type`, `calibre`, `numero_serie`) VALUES ('Colt', 'Python', 'Revolver', '357 Magnum', '65433HY8');
INSERT INTO `fil_rouge`.`arme` (`marque`, `modele`, `type`, `calibre`, `numero_serie`) VALUES ('Berretta', '92S', 'Pistolet', '9mm', '1235TYU678');

INSERT INTO `fil_rouge`.`vehicule` (`infos_complementaire`, `marque`, `modele`, `type`, `couleur_vehicule`, `immatriculation`) VALUES ('Antiquité', 'Citroen', '2CV', 'Voiture', 'Gris', '12AB45');
INSERT INTO `fil_rouge`.`vehicule` (`infos_complementaire`, `marque`, `modele`, `type`, `couleur_vehicule`, `immatriculation`) VALUES ('', 'Renault', 'Kangoo', 'Utilitaire', 'Jaune', 'AB345RT');
INSERT INTO `fil_rouge`.`vehicule` (`marque`, `modele`, `type`, `couleur_vehicule`, `immatriculation`) VALUES ('Scania', 'Serie G', 'Camion', 'Blanc', 'ER654YU');

INSERT INTO `fil_rouge`.`affaire` (`classee`, `date_cloture`, `date_creation`, `nom_affaire`, `pieces_conviction`) VALUES (True, '12/03/1956', '01/02/1956', 'La Brouette disparue', 'Trace de pas, trace de roue.');
INSERT INTO `fil_rouge`.`affaire` (`classee`, `date_cloture`, `date_creation`, `nom_affaire`) VALUES (False, '', '30/10/1985', 'Le petit Grégory');
INSERT INTO `fil_rouge`.`affaire` (`classee`, `date_cloture`, `date_creation`, `nom_affaire`, `pieces_conviction`) VALUES (True, '21/06/2017', '13/12/2015', 'La sucette abandonnée', '');
