package fr.cda.restaurant.restaurant;

import fr.cda.restaurant.exceptions.BadRequestException;
import fr.cda.restaurant.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository
    ) {

        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

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

        if (restaurant.getHoraire() == null) {
            erreurs.add("Les horaires du restaurant sont obligatoires");
        }

       //if (restaurant.getCouvertsMax() === null) {
        //    erreurs.add("Le nombre de couverts max du restaurant est obligatoire");
        //}

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
}
