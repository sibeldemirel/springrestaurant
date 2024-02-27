package fr.cda.restaurant.menu;



import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Optional<Menu> findByNom(String nom);

    // SELECT * FROM menu WHERE restaurant_id IS ...
    Optional<List<Menu>> findAllByRestaurantId(Integer id);

    // SELECT * FROM menu WHERE realisateur_nom IS ...
    Optional<List<Menu>> findAllByRestaurantName(String nomRestaurant);

}
