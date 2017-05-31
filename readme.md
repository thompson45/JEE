# TP JAX-RS

Dans ce TP, vous allez utiliser Jersey afin de réaliser une API REST permettant de gérer une bibliothèque.

## Mise en place

A partir du squelette fourni, créez un projet Maven dans votre IDE, toutes les dépendances sont pré-configurées. Lancez la commande suivante ```mvn install``` pour télécharger l'ensemble des dépendances nécessaires, puis lancez l'application normalement.

Accédez depuis votre navigateur ou depuis **Postman** à [http://localhost:8080](http://localhost:8080) (attention si vous modifiez la configuration du serveur) et vous devriez avoir une **erreur 404** de la part de Jetty. C'est normal, aucun endpoint n'a été défini.

## Étapes de réalisation de l'API

1. Réalisation d'un endpoint en `GET` pour récupérer la liste de tous les livres disponibles dans la bibliothèque (deux exemples sont déjà présents à l'initialisation).

2. Réalisation d'un endpoint en `GET` qui prend un paramètre dans l'URL pour récupérer un livre par son **id**.

3. Réalisation d'un endpoint en `POST` qui prend en paramètres les différents attributs d'un livre pour l'ajouter à la bibliothèque.

4. Réalisation d'un endpoint en `DELETE` qui prend un paramètre dans l'URL pour supprimer un livre par son **id**.

Vous pouvez vous servir des requètes Postman enregistrées dans le fichier `TP_Library.postman_collection.json` afin de vérifier votre avancement.

## Pour aller plus loin :

- Réalisation d'un endpoint en **PUT** qui prend en paramètres les différents attributs d'un livre pour éditer un ou plusieurs de ses attributs.
- Ajout d'un attribut "available" pour tagger un livre comme disponible ou non et ajout d'un paramètre (query param) dans le premier endpoint pour filtrer les livres à afficher.
- Autre...amusez-vous ;-)
