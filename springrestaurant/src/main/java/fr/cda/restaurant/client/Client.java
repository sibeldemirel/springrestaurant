package fr.cda.restaurant.client;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "client")
@Builder
@AllArgsConstructor

public class Client {
@Id
    private Integer id;
    private String nom;
    private Integer  phoneNumber;
}

