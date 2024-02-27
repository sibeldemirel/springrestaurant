package fr.cda.restaurant.restaurant;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.cda.restaurant.equipment.Equipment;
import fr.cda.restaurant.menu.Menu;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "restaurant")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Builder
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private LocalDate horaire;

    @Column(nullable = false)
    private int couvertsMax;

    @Column(nullable = false)
    private int couvertsDispo;

    @Column(nullable = false)
    private boolean annivDipo;

    @ManyToOne // One Restaurant to Many Menus
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne // One Restaurant to Many Equipments
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne // One Restaurant to Many Reviews
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne // One Restaurant to Many Reservations
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @Column(nullable = false)
    private int totalRating;
}
