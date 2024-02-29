package fr.cda.restaurant.reservation.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservationRequestDto {
    private String nomClient;
    private int telephoneClient;
    private String nomRestaurant;
    private LocalDate dateReservation;
    private Integer nbInvite;
    private boolean anniv;
}
