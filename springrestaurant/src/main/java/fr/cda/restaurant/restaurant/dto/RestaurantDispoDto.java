package fr.cda.restaurant.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RestaurantDispoDto {
    private String nomRestaurant;
    private LocalDate date;
    private int couvertsDispo;
}
