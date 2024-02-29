package fr.cda.restaurant.restaurant;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.cda.restaurant.equipment.Equipment;
import fr.cda.restaurant.menu.Menu;
import fr.cda.restaurant.reservation.Reservation;
import fr.cda.restaurant.review.Review;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private int couvertsMax;

    @Column(nullable = false)
    private int couvertsDispo;

    @Column(nullable = false)
    private boolean annivDispo;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Menu> menus = new ArrayList<>();

    @ManyToOne // One Restaurant to Many Equipments
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne // One Restaurant to Many Reviews
    @JoinColumn(name = "review_id")
    private Review review;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Reservation> reservations = new ArrayList<>();

    @Column(nullable = false)
    private int totalRating;

}
