package fr.cda.restaurant.client;

import fr.cda.restaurant.exceptions.BadRequestException;
import fr.cda.restaurant.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        if (client.getNom() == null || client.getNom().trim().isEmpty()) {
            erreurs.add("Le nom du client est obligatoire");
        }

        if (String.valueOf(client.getTelephone()).length() < 9 || String.valueOf(client.getTelephone()).length() > 15) {
            erreurs.add("Le numéro de téléphone du client doit contenir entre 9 et 15 chiffres.");
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

    public List<Client> findByNom(String nom) {
        return clientRepository.findByNom(nom);
    }

    public Client findOrCreateClient(String nom, int telephone) {

        Optional<Client> clientOpt = clientRepository.findByNomAndTelephone(nom, telephone);
        return clientOpt.orElseGet(() -> {

            Client newClient = new Client();
            newClient.setNom(nom);
            newClient.setTelephone(telephone);
            return clientRepository.save(newClient);
        });
    }


}