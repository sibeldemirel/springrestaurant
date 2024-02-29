package fr.cda.restaurant.restaurant;

import fr.cda.restaurant.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository  extends JpaRepository<Restaurant, Integer> {
    Optional<Restaurant> findByNom(String nom);
}
