# Application de Gestion de Restaurant

## Prérequis
Pour exécuter le projet, vous devez d'abord démarrer Docker :
- Exécutez `docker-compose up -d` dans le terminal à la racine du projet pour lancer les conteneurs Docker nécessaires.

## Connexion à la Base de Données
- **Nom de la base de données** : `restaurant`
- **Nom d'utilisateur** : `restaurantadmin`
- **Mot de passe** : `restaurant`

## Lien de Base
L'application est accessible à l'adresse suivante en local :
- `http://localhost:8080`

## Routes Principales
L'application expose plusieurs routes pour interagir avec le système de gestion de restaurant :
- `/restaurants` : Gestion des restaurants
- `/clients` : Gestion des clients
- `/reservations` : Gestion des réservations utilisateurs
- `/equipments` : Gestion des équipements d'un restaurant
- `/menus` : Gestion des menus
- `/reviews` : Gestion des avis utilisateurs

## Documentation API
La documentation de l'API est accessible via Swagger UI à l'adresse suivante : `http://localhost:8080/api/restaurant/docs`.
Cette interface vous permet de visualiser et de tester toutes les routes disponibles de l'API.

## Diagramme UML

Ci-dessous, le modèle UML simplifié de l'application :

```plantuml
@startuml

class Restaurant implements management{
  - id : int
  - nom : String 
  - adresse : String 
  - horaire : LocalDate 
  - typeCuisine : String
  - couvertsMax : int 
  - couvertsDispo : int 
  - annivDispo : Boolean 
  - menu : Menu
  - equipment : Equipment
  - review : Review
  - reservation : Reservation
  - createRestaurant() : private
  - totalRating : int
}

Interface management{
  + totalGain(): public
  + getCouvertsDispo(): public
  + totalRating() : public
}

class Equipment {
  - id : int
  - name : String 
}

class Reservation{
  - id : int
  - client : Client 
  - nomResto : String
  - creneauH : LocalDate 
  - nbInvite : int 
  - anniv : Boolean 
  + reserver() : public
  - getReservationByDate(): private
}

class Client{
  - id : int
  - nomClient : String 
  - phoneNumber : String 
}

class Menu {
  - id : int
  - nom : String
  - nomResto : String
  - prix : int 
  - entree : String 
  - plat : String 
  - dessert : String 
  - boisson : String 
  - createMenu() : private
}

class Review{
  - id : int
  - nomResto : String
  - pseudo : String
  - rating: int
  - comment : String
}

skin rose

Restaurant "1" o-- "1..*" Menu
Restaurant "1" o-- "1" Equipment
Restaurant "1" o-- "0..*" Reservation
Restaurant "1" o-- "0..*" Review
Client "1" o-- "1..*" Reservation

@enduml
```

Ce modèle illustre les principales entités de l'application et leurs relations.