package fr.cda.restaurant.menu.dto;

import fr.cda.restaurant.restaurant.Restaurant;
import lombok.Data;

@Data
public class MenuCompletDto {
    private String nom;
    private String entree;
    private String plat;
    private String dessert;
    private String boisson;
    private int prix;
}
