package fr.cda.restaurant.reservation;

import fr.cda.restaurant.client.Client;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "reservation")
@Builder
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne // One reservation to one client
    @JoinColumn(name = "client_id")
    private  Client client;

    @Column(nullable = false)
    private LocalDate creneauH;

    @Column(nullable = false)
    private Integer nbInvite;

    @Column(nullable = false)
    private boolean anniv;


}