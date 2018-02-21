## Pour afficher les utilisateurs :
### faire : git pull --rebase origin dev
### avant de lancer Springboot :
- dans mysql, créer une BDD (un schema ) qui s'appelle "fil_rouge" et c'est tout pas de tables a crée...
- copier data.sql de "src\main\archives_sql" dans "src\main\resources"
- lancer springboot, il crée les tables et insert les données ( 4 utilisateurs pour l'instant ).
- supprimer data.sql de "src\main\resources" ET AUSSI sur notre disque dur, grace à Eclipse qui le copie automatiquement ( ex: eclipse-workspace\Fil_Rouge\target\classes ), sinon il va dupliquer les data à chaque fois que vous lancez l'application.
### dans Postman : il y a 2 Url qui renvoie du JSON avec GET :
- http://localhost:8080/api/utilisateurs
- http://localhost:8080/api/utilisateur/{id}
### Il y a une URL pour faire un DELETE utilisateur en renseignant son id:
- http://localhost:8080/api/utilisateur/delete/{id}
### L'ajout d'un utilisateur ne fonctionne pas encore ( n'insert que des null ).
- http://localhost:8080/api//utilisateur/add ( TODO )