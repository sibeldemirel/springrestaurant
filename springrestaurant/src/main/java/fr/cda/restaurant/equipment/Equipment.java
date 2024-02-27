package fr.cda.restaurant.equipment;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Boolean equiped;

    public Equipment(Integer id, String name, Boolean equiped) {
        this.id = id;
        this.name = name;
        this.equiped = equiped;
    }
}
