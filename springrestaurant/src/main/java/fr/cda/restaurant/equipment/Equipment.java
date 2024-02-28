package fr.cda.restaurant.equipment;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "equipment")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Builder
@AllArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean equiped;

}
