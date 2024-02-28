package fr.cda.restaurant.client;

import fr.cda.restaurant.exceptions.BadRequestException;
import fr.cda.restaurant.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(
            ClientRepository clientRepository
    ) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client save(Client client) throws BadRequestException {
        verifyClient(client);

        return clientRepository.save(client);
    }

    private static void verifyClient(Client client) {
        List<String> erreurs = new ArrayList<>();

        if (client.getNom() == null) {
            erreurs.add("Le nom du client est obligatoire");
        }

        if (String.valueOf(client.getPhoneNumber()).length() != 10) {
            erreurs.add("Le numéro de portable du client doit contenir 10 chiffres");
        }

        if (!erreurs.isEmpty()) {
            throw new BadRequestException(erreurs);
        }
    }

    public Client findById(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Aucun client avec l'ID " + id)
                );
    }

    public void deleteById(Integer id) {
        Client client = this.findById(id);
        clientRepository.delete(client);
    }

    public Client update(Client client, Integer id) {
        if (!clientRepository.existsById(id)) {
            throw new NotFoundException("Aucun client avec l'ID " + id);
        }
        client.setId(id);
        return clientRepository.save(client);
    }

    public Client findByNom(String nom) {
        return clientRepository.findByNom(nom)
                .orElseThrow(
                        () -> new NotFoundException("Aucun client avec le nom " + nom)
                );
    }
}