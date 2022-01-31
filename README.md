# Intro : Projet de gestion de d'événements et de participants

1 / Installation

## A. RECUPERATION DU PROJET

1. Cloner la branche main
- git clone https://github.com/NRouyer38/ProjetJEE.git

## B. BASE DE DONNEES

1. Installez le paquet postgresql
2. Connectez avec l'utilisateur postgres en utilisant la commande suivante :
- sudo -i -u postgres
3. Lancez l'invite de commande Postgresql à l'aide de la commande suivante:
- psql '''
4. Créer un utilisateur
- CREATE USER test;
5. Donnez-lui le droit de créer un base de données.
- ALTER ROLE test WITH CREATEDB ;
6. Créez un base portant le même nom que l'utilisateur :
- CREATE DATABASE test OWNER test ; 
7. Ajoutez un mot de passe à votre utilisateur
- ALTER USER test WITH ENCRYPTED PASSWORD 'test';
8. Quittez Postgresl avec la commande :
- \q 
9. Quittez l'utilisateur postgres avec la commande :
- exit
10. Lancez Postgresql avec la commande suivante (normalement vous êtes automatiquement connecté
avec la base de données test). :
- psql 

## C. IDE JAVA (IntelliJ IDEA)

1. Télécharger l'IDE depuis le lien suivant :
- https://www.jetbrains.com/fr-fr/idea/download/#section=linux
2. Dézipper le fichier
3. Lancer le fichier 'idea.sh' situé dans le bin pour démarrer l'IDE


NB: Parfois, l'IDE rencontre des problèmes au niveau des lobraries. Dans ce cas, il faut vider le caches en suivant ces étapes :
- File > Invalidate Caches > Invalidate & Restart

# Quelques notion à savoir

## Dépendances du Projet :

- Hibernate (ajouté dans les dependecies dans le pom)
- Maven (ajouté dans les dependecies dans le pom)
- Spring boot MVC (ajouté dans les dependecies dans le pom)
- PostgreSQL (ajouté dans les dependecies dans le pom)


## Propriété de la BDD :

- url=jdbc:postgresql://localhost:5432/test
- username = test
- password = test

## Pages web :

- page d'accueil = localhost:8080/home
- page des événements = localhost:8080/listEvenement
- page d'ajout d'événements = localhost:8080/addEvenementForm
- page des participants = localhost:8080/listParticipant
- page d'ajout des participants = localhost:8080/addParticipantForm
