## Pour afficher les utilisateurs :
### faire : git pull --rebase origin dev
### avant de lancer Springboot :
- dans mysql, créer une BDD ( schema ) qui s'appelle "fil_rouge" et c'est tout pas de tables a crée...
- copier schema.sql & data.sql de "src\main\archives_sql" dans "src\main\resources"
- lancer springboot, il crée les tables et insert les données
- si il n'y a pas d'erreur dans la console ( en principe y en a pas mais bon).
- supprimer schema.sql & data.sql de "src\main\resources" ( sinon il va dupliquer les data à chaque fois que vous lancez Springboot )
### dans Postman : il y a 2 Url qui renvoie du JSON avec GET :
- http://localhost:8080/api/utilisateurs
- http://localhost:8080/api/utilisateur/{id}