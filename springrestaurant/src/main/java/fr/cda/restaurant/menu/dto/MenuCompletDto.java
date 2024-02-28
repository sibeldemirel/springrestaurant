package fr.cda.restaurant.menu.dto;

import fr.cda.restaurant.restaurant.Restaurant;
import lombok.Data;

@Data
public class MenuCompletDto {
    private Integer id;
    private String nom;
    private Restaurant restaurant;
    private int prix;
    private String entree;
    private String plat;
    private String dessert;
    private String boisson;
}
