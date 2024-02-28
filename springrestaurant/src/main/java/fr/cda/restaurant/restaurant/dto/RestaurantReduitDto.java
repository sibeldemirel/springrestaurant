package fr.cda.restaurant.restaurant.dto;

import fr.cda.restaurant.equipment.Equipment;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RestaurantReduitDto {
    private String nom;
    private String adresse;
    private LocalDate horaire;
    private boolean annivDispo;
    private Equipment equipment;
    private int totalRating;
}

