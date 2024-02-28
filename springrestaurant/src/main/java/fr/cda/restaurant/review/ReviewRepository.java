package fr.cda.restaurant.review;

import fr.cda.restaurant.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    // SELECT * FROM menu WHERE restaurant_id IS ...
    Optional<List<Review>> findAllByRestaurantId(Integer id);

    // SELECT * FROM menu WHERE realisateur_nom IS ...
    Optional<List<Review>> findAllByRestaurantName(String nomRestaurant);
}
