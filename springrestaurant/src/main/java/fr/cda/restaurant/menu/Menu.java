package fr.cda.restaurant.menu;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.cda.restaurant.restaurant.Restaurant;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "menu")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Builder
@AllArgsConstructor
public class Menu {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne // One Restaurant to Many Menus
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private Restaurant restaurant;

    @Column(nullable = false)
    private int prix;

    @Column(nullable = false)
    private String entree;

    @Column(nullable = false)
    private String plat;

    @Column(nullable = false)
    private String dessert;

    @Column(nullable = false)
    private String boisson;
}
