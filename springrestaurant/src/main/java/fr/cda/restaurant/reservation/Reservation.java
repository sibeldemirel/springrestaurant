package fr.cda.restaurant.reservation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fr.cda.restaurant.client.Client;
import fr.cda.restaurant.restaurant.Restaurant;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne // One reservation to one client
    @JoinColumn(name = "client_id")
    private  Client client;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;


    @Column(nullable = false)
    private LocalDate dateReservation;

    @Column(nullable = false)
    private Integer nbInvite;

    @Column(nullable = false)
    private boolean anniv;


}