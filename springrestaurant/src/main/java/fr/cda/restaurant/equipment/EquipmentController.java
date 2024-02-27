package fr.cda.restaurant.equipment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
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
}
