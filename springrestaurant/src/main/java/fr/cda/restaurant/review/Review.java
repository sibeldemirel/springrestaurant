package fr.cda.restaurant.review;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String nomResto;
    @Column(nullable = false)
    private String pseudo;
    @Column(nullable = false)
    private int rating;
    @Column(nullable = false)
    private String comment;
}
