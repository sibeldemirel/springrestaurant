package fr.cda.restaurant.restaurant;

import fr.cda.restaurant.restaurant.dto.RestaurantCompletDto;
import fr.cda.restaurant.restaurant.dto.RestaurantReduitDto;
import fr.cda.restaurant.restaurant.mapper.RestaurantMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RestaurantController {

    private final RestaurantService restaurantService;

    private final RestaurantMapper restaurantMapper;

    public RestaurantController(
            RestaurantService restaurantService,
            RestaurantMapper restaurantMapper
    ) {
        this.restaurantService = restaurantService;
        this.restaurantMapper = restaurantMapper;
    }

    @GetMapping
    public List<RestaurantReduitDto> findAll() {
        return restaurantMapper.toRestaurantReduit(restaurantService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant save(@RequestBody Restaurant restaurant) {

        return restaurantService.save(restaurant);
    }

    @GetMapping("/{id}") // /restaurant/1
    public RestaurantCompletDto findById(@PathVariable Integer id) {
        Restaurant restaurant = restaurantService.findById(id);

        return restaurantMapper.toRestaurantComplet(restaurant);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        restaurantService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Restaurant update(@RequestBody Restaurant restaurant, @PathVariable Integer id) {
        return restaurantService.update(restaurant, id);
    }

    @GetMapping("/search") // /restaurant/search?nom=SushiLand
    public Restaurant findByNom(@RequestParam String nom) {
        return restaurantService.findByNom(nom);
    }

    @GetMapping("complet/{restaurantName}") // /restaurant/complet/SushiLand
    public List<RestaurantCompletDto> findByNomRestaurant(@PathVariable String restaurantName) {
        return restaurantMapper.toRestaurantComplet(restaurantService.findByNomRestaurant(restaurantName));
    }

    @GetMapping("reduit/{restaurantName}") // /restaurant/reduit/SushiLand
    public List<RestaurantReduitDto> findByNomRestaurantReduit(@PathVariable String restaurantName) {
        return restaurantMapper.toRestaurantReduit(restaurantService.findByNomRestaurant(restaurantName));
    }

}
