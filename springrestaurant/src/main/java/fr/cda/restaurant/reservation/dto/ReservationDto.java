package fr.cda.restaurant.reservation.dto;

import fr.cda.restaurant.client.Client;

import lombok.Data;

import java.time.LocalDate;

public class ReservationDto {
    @Data
    private Integer id;
    private Client nom;

    private Client phoneNumber;
    private String nomResto;
    private LocalDate creneauH;

    private Integer nbInvite;

    private boolean anniv;



}
