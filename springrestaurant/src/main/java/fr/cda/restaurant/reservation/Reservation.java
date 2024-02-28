package fr.cda.restaurant.reservation;

import fr.cda.restaurant.client.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Reservation")
@Builder
@AllArgsConstructor
public class Reservation {
    @Id
    private Integer id;
    @ManyToOne
    private  Client client;
    private LocalDate creneauH;
    private Integer nbInvite;
    private boolean anniv;


}