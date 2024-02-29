package fr.cda.restaurant.restaurant.dto;

import fr.cda.restaurant.equipment.Equipment;
import fr.cda.restaurant.equipment.dto.EquipmentReduitDto;
import fr.cda.restaurant.menu.Menu;
import fr.cda.restaurant.menu.dto.MenuCompletDto;
import fr.cda.restaurant.menu.dto.MenuReduitDto;
import fr.cda.restaurant.reservation.Reservation;
import fr.cda.restaurant.reservation.dto.ReservationCompletDto;
import fr.cda.restaurant.reservation.dto.ReservationReduitDto;
import fr.cda.restaurant.review.Review;
import fr.cda.restaurant.review.dto.ReviewReduitDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RestaurantCompletDto {
    private Integer id;
    private String nom;
    private String adresse;
    private int couvertsMax;
    private boolean annivDispo;
    private List<MenuReduitDto> menus;
    private List<EquipmentReduitDto> equipments;
   // private List<ReviewReduitDto> reviews;
    private List<ReservationReduitDto> reservations;
    private int totalRating;
}
