package fr.cda.restaurant.reservation.dto;

import fr.cda.restaurant.client.Client;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationReduitDto {
    private Client client;
    private LocalDate dateReservation;
    private Integer nbInvite;
    private boolean anniv;
}
