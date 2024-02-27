package fr.cda.restaurant.menu;



import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;


public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
