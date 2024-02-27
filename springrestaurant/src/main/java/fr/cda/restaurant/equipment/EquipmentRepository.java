package fr.cda.restaurant.equipment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
    Optional<Equipment> findByEquipmentName(String name);
    Optional<Equipment> findByEquipmentEquiped(String name);
}
