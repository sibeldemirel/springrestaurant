package fr.cda.restaurant.restaurant.dto;

import fr.cda.restaurant.equipment.Equipment;
import fr.cda.restaurant.equipment.dto.EquipmentReduitDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RestaurantReduitDto {
    private String nom;
    private String adresse;
    private boolean annivDispo;
    private List<EquipmentReduitDto> equipments;
    private int totalRating;
}

