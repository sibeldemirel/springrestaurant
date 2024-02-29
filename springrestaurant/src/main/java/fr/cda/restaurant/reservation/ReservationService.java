package fr.cda.restaurant.reservation;


import fr.cda.restaurant.exceptions.BadRequestException;
import fr.cda.restaurant.exceptions.NotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    public ReservationService(
            ReservationRepository reservationRepository
    ) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation save(Reservation reservation) throws BadRequestException {
        verifyReservation(reservation);

        return reservationRepository.save(reservation);
    }

    private static void verifyReservation(Reservation reservation) {
        List<String> erreurs = new ArrayList<>();

        if (reservation.getClient() == null) {
            erreurs.add("Le client est obligatoire");
        }

        if (reservation.getDateReservation() == null) {
            erreurs.add("Le creneau horaire est obligatoire");
        }

        if (reservation.getNbInvite() == null) {
            erreurs.add("Le nombre d'invite est obligatoire");
        }

        if (!erreurs.isEmpty()) {
            throw new BadRequestException(erreurs);
        }
    }

    public Reservation update(Reservation reservation, Integer id) {
        if (!reservationRepository.existsById(id)) {
            throw new NotFoundException("Aucune réservation avec l'ID " + id);
        }
        reservation.setId(id);
        return reservationRepository.save(reservation);
    }

    public Reservation findById(Integer id) {
        return reservationRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Aucune réservation avec l'ID " + id)
                );
    }
    public void deleteById(Integer id) {
        Reservation reservation = this.findById(id);
        reservationRepository.delete(reservation);
    }

    public List<Reservation> findAllByRestaurantId(Integer id) {
        return reservationRepository.findAllByRestaurantId(id)
                .orElseThrow(() -> new NotFoundException("Aucune réservation trouvé avec le restaurant ID " + id));
    }

    public Optional<List<Reservation>> findAllByRestaurantName(String nomRestaurant) {
        return Optional.ofNullable(reservationRepository.findAllByRestaurantNom(nomRestaurant)
                .orElseThrow(() -> new NotFoundException("Aucune réservation trouvé avec le restaurant nom " + nomRestaurant)));
    }


    public int getTotalCouvertsReservesPourDate(Integer restaurantId, LocalDate dateReservation) {

        List<Reservation> reservations = reservationRepository.findByRestaurantIdAndDateReservation(restaurantId, dateReservation);

        int totalCouverts = reservations.stream()
                .mapToInt(Reservation::getNbInvite)
                .sum();

        return totalCouverts;
    }

}