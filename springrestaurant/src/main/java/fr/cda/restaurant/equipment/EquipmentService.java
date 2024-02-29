package fr.cda.restaurant.equipment;

import fr.cda.restaurant.exceptions.NotFoundException;
import fr.cda.restaurant.menu.Menu;
import fr.cda.restaurant.restaurant.Restaurant;
import fr.cda.restaurant.restaurant.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    private final RestaurantRepository restaurantRepository;

    public EquipmentService(
            EquipmentRepository equipmentRepository,
            RestaurantRepository restaurantRepository) {
        this.equipmentRepository = equipmentRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public Equipment save(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    //public Optional<Equipment> findAllEquiped(Equipment equipment) {
    //    return equipmentRepository.findByEquipmentEquiped(String.valueOf(equipment.getEquiped()));
    //}

    @Transactional
    public Equipment update(Equipment equipment, Integer id) {
        equipment.setId(id);
        return equipmentRepository.save(equipment);
    }

    private Equipment findById(Integer id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("no equipment found"));
    }

    @Transactional
    public void deleteById(Integer id) {
        Equipment equipment = this.findById(id);
        equipmentRepository.delete(equipment);
    }

    public Equipment createEquipmentForRestaurant(Integer restaurantId, Equipment equipment) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NotFoundException("Restaurant non trouvé avec l'ID: " + restaurantId));
        equipment.setRestaurant(restaurant);
        return equipmentRepository.save(equipment);
    }
}
