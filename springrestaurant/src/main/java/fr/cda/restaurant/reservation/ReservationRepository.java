
package fr.cda.restaurant.reservation;

import fr.cda.restaurant.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findAllByCreneau(LocalDateTime creneauHRecherche, LocalDateTime creneauHRechercheMax);
}
