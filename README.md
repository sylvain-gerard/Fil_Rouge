## Pratiques très conseillées:
### Depuis gitBash avant de faire des modifications:
- git checkout dev
- git pull --rebase origin dev => se mettre à jour
- créer sa branche : git checkout -b [nom_de_la_branche]
- faire son job et tester dans Postman...
- git status / git add / git commit => attendre avant de pusher !
- git checkout dev
- git pull
- git merge [nom_de_la_branche] => voir si conflits, résoudre les conflits éventuels
- git push
- git branch -d [nom_de_la_branche] => supprimer sa branche

### Avant de lancer la premièez fois Springboot :
- dans mysql, créer une BDD (un schema ) qui s'appelle "fil_rouge", pas besoin de créer les tables.
- copier le fichier "data.sql" depuis "src\main\archives_sql" dans "src\main\resources"
- lancer Springboot, il crée les tables et insert les données contenues dans "data.sql".
- supprimer data.sql de "src\main\resources" ET faire un refresh du projet ( F5 ), le but est que Springboot ne prennes en compte les INSERT de "data.sql" qu'une seule fois. Sinon il va dupliquer les data à chaque fois que vous lancez l'application.
- Ne faire cela qu'une seule fois, sauf vous voulez modifier les tables en changeant les attributs des modèles.
- En cas de modifications, il vaut mieux supprimer la BDD "fil_rouge" ( clic-G + Drop Schema ) puis la recrée ( clic Droit + Create Schema ). Puis reprendre à l'étape 2.

### Dans Postman : il y a 2 Url qui renvoie du JSON avec GET :
- http://localhost:8080/api/utilisateurs
- http://localhost:8080/api/utilisateur/{id}
### Une URL pour faire un DELETE d'un utilisateur en renseignant son id:
- http://localhost:8080/api/utilisateur/{id}
### L'ajout ( POST ) et l'upadte ( PUT ) d'un utilisateur se fait depuis:
- http://localhost:8080/api/utilisateurs

#### Idem " http://localhost:8080/api/***** " pour arme(s), vehicule(s), affaire(s) et suspect(s)
