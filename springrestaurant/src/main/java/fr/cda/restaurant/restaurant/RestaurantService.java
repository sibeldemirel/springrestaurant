package fr.cda.restaurant.restaurant;

import fr.cda.restaurant.exceptions.BadRequestException;
import fr.cda.restaurant.exceptions.NotFoundException;
import fr.cda.restaurant.reservation.Reservation;
import fr.cda.restaurant.reservation.ReservationRepository;
import fr.cda.restaurant.restaurant.dto.RestaurantDispoDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    private final ReservationRepository reservationRepository;

    public RestaurantService(
            RestaurantRepository restaurantRepository,
            ReservationRepository reservationRepository
    ) {

        this.restaurantRepository = restaurantRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Transactional
    public Restaurant save(Restaurant restaurant) throws BadRequestException {
        verifyRestaurant(restaurant);

        return restaurantRepository.save(restaurant);
    }

    private static void verifyRestaurant(Restaurant restaurant) {
        List<String> erreurs = new ArrayList<>();

        if (restaurant.getNom() == null) {
            erreurs.add("Le nom du restaurant est obligatoire");
        }

        if (restaurant.getAdresse() == null) {
            erreurs.add("L'adresse du restaurant est obligatoire");
        }

        if (!erreurs.isEmpty()) {
            throw new BadRequestException(erreurs);
        }
    }

    public Restaurant findById(Integer id) {
        return restaurantRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Aucun restaurant avec l'ID " + id)
                );
    }

    public void deleteById(Integer id) {
        Restaurant restaurant = this.findById(id);
        restaurantRepository.delete(restaurant);
    }

    @Transactional
    public Restaurant update(Restaurant restaurant, Integer id) {
        if (!restaurantRepository.existsById(id)) {
            throw new NotFoundException("Aucun restaurant avec l'ID " + id);
        }
        restaurant.setId(id);
        return restaurantRepository.save(restaurant);
    }

    public Restaurant findByNom(String nom) {
        return restaurantRepository.findByNom(nom)
                .orElseThrow(
                        () -> new NotFoundException("Aucun restaurant avec le nom " + nom)
                );
    }

    public Restaurant findByNomRestaurant(String nom) {
        return restaurantRepository.findByNom(nom)
                .orElseThrow(
                        () -> new NotFoundException("Aucun restaurant avec le nom " + nom)
                );
    }

    public RestaurantDispoDto getDispoParDate(Integer restaurantId, LocalDate date) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NotFoundException("Restaurant non trouvé"));

        int totalCouvertsReserves = reservationRepository.findByRestaurantIdAndDateReservation(restaurantId, date)
                .stream()
                .mapToInt(Reservation::getNbInvite)
                .sum();

        int couvertsDispo = restaurant.getCouvertsMax() - totalCouvertsReserves;

        return new RestaurantDispoDto(restaurant.getNom(),date, couvertsDispo);
    }

}
