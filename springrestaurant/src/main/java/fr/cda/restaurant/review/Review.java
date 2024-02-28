package fr.cda.restaurant.review;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "review")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Builder
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @Column(name = "nomrestaurant")
    private String restaurantName;

    @Column(nullable = false)
    private String pseudo;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private String comment;
}
