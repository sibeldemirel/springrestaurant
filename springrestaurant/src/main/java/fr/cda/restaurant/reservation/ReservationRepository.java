
package fr.cda.restaurant.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    // SELECT * FROM menu WHERE restaurant_id IS ...
    Optional<List<Reservation>> findAllByRestaurantId(Integer id);

    // SELECT * FROM menu WHERE realisateur_nom IS ...
    Optional<List<Reservation>> findAllByRestaurantNom(String nomRestaurant);
}
