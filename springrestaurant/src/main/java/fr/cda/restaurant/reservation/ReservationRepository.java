
package fr.cda.restaurant.reservation;

import fr.cda.restaurant.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
