To run the project you first need to run docker :
- `docker-compose up -d`

To connect to the database:
    database name : `restaurant`
    username : `restaurantadmin`
    password : `restaurant`

base link : http://localhost:8080

Swagger path : http://localhost:8080/api/restaurant/docs

```@startuml

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
  - totalRating : totalRating()
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