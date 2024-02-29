package fr.cda.restaurant.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findByNom(String nom);

    Optional<Client> findByNomAndTelephone(String nom, int telephone);


}
