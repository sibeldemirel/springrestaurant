package fr.cda.restaurant.menu.dto;

import lombok.Data;

@Data
public class MenuReduitDto {
    private String nom;
    private String entree;
    private String plat;
    private String dessert;
    private String boisson;
    private int prix;
}
