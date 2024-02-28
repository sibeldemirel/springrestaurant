package fr.cda.restaurant.client;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "client")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Builder
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private int  phoneNumber;
}

