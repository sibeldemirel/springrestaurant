package fr.cda.restaurant.restaurant.dto;

import fr.cda.restaurant.equipment.Equipment;
import fr.cda.restaurant.menu.Menu;
import fr.cda.restaurant.reservation.Reservation;
import fr.cda.restaurant.review.Review;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RestaurantCompletDto {
    private Integer id;
    private String nom;
    private String adresse;
    private int couvertsMax;
    private int couvertsDispo;
    private boolean annivDispo;
    private Menu menu;
    private Equipment equipment;
    private Review review;
    private Reservation reservation;
    private int totalRating;
}
