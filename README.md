
Here is the uml graph of the preoject :

```
@startuml

class Restaurant implements management{
  - nom : String 
  - adresse : String 
  - horaire : LocalDate 
  - typeCuisine : String
  - couvertsMax : int 
  - couvertsDispo : int 
  - annivDispo : Boolean 
  - menu : Menu
  - createRestaurant() : private
  - totalRating : int
}

Interface management{
  + totalGain(): public
  + getCouvertsDispo(): public
}

class Equipment {
  - accessibilite : Boolean 
  - terasse : Boolean 
  - kidsRoom : Boolean 
  - wifi : Boolean 
}

class Reservation{
  - client : Client 
  - nomResto : String
  - creneauH : LocalDate 
  - nbInvite : int 
  - anniv : Boolean 
  + reserver() : public
  - getReservationByDate(): private
}

class Client{
  - nomClient : String 
  - phoneNumber : String 
}

class Menu {
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
