package fr.cda.restaurant.equipment;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment save(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    public Optional<Equipment> findAllByName(Equipment equipment) {
        return equipmentRepository.findByEquipmentName(equipment.getName());
    }

    //public Optional<Equipment> findAllEquiped(Equipment equipment) {
    //    return equipmentRepository.findByEquipmentEquiped(String.valueOf(equipment.getEquiped()));
    //}

    public Equipment update(Equipment equipment, Integer id) {
        equipment.setId(id);
        return equipmentRepository.save(equipment);
    }

    private Equipment findById(Integer id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("no equipment found"));
    }

    public void deleteById(Integer id) {
        Equipment equipment = this.findById(id);
        equipmentRepository.delete(equipment);
    }


}
