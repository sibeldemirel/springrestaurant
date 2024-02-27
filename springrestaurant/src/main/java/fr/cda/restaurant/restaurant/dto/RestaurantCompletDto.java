package fr.cda.restaurant.restaurant.dto;

import fr.cda.restaurant.equipment.Equipment;
import fr.cda.restaurant.menu.Menu;

import java.time.LocalDate;

public class RestaurantCompletDto {
    private Integer id;
    private String nom;
    private String adresse;
    private LocalDate horaire;
    private int couvertsMax;
    private int couvertsDispo;
    private boolean annivDispo;
    private Menu menu;
    private Equipment equipment;
    private Review review;
    private Reservation reservation;
    private int totalRating;
}
