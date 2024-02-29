package fr.cda.restaurant.equipment;

import fr.cda.restaurant.equipment.dto.EquipmentReduitDto;
import fr.cda.restaurant.equipment.mapper.EquipmentMapper;
import fr.cda.restaurant.menu.Menu;
import fr.cda.restaurant.menu.dto.MenuReduitDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipments")
public class EquipmentController {
    private final EquipmentService equipmentService;

    private final EquipmentMapper equipmentMapper;

    public EquipmentController(
            EquipmentService equipmentService,
            EquipmentMapper equipmentMapper) {
        this.equipmentService = equipmentService;
        this.equipmentMapper = equipmentMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipment save(@RequestBody Equipment equipment) {
        return equipmentService.save(equipment);
    }

    @GetMapping
    public List<Equipment> findAll(){
        return equipmentService.findAll();
    }

    @PutMapping("{id}")
    public Equipment update(@RequestBody Equipment equipment, @PathVariable Integer id) {
        equipment.setId(id);
        return equipmentService.update(equipment, id);
    }

    //@GetMapping("/available")
    //public List<Equipment> getAllAvailable(@PathVariable String name){
    //    return  equipmentService.findAllEquiped(name);
    //}
    @DeleteMapping
    public void deleteById(@PathVariable int id) {
        equipmentService.deleteById(id);
    }

    @PostMapping("/{restaurantId}/equipments")
    public ResponseEntity<EquipmentReduitDto> addEquipmentToRestaurant(@PathVariable Integer restaurantId, @RequestBody Equipment equipmentDetails) {
        Equipment newEquipment = equipmentService.createEquipmentForRestaurant(restaurantId, equipmentDetails);
        EquipmentReduitDto EquipmentDto = equipmentMapper.toEquipmentReduit(newEquipment);
        return new ResponseEntity<>(EquipmentDto, HttpStatus.CREATED);
    }
}
