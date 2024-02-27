package fr.cda.restaurant.client;

import java.rmi.server.RemoteServer;
import java.util.List;

public class ClientService {
    private final ClientRepository clientRepository,
    private final ReservationService reservationService;

    public ClientService(
            ClientRepository clientRepository,
            ReservationService reservationService) {
        this.clientRepository = clientRepository;
        this.reservationService = reservationService;
    }


    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Client findById(int id){
        return clientRepository
                .findById(id).orElseThrow(
                        () -> new NotFoundException(
                        "Aucun client avec l'ID " + id+"Merci de vérifier L'ID demandé")
                );
    }

    public void deleteById(Integer id) {
        this.findById(id);

        List<Reservation> reservationDeCeClient = reservationService.findAllByClientId(id);

        reservationDeCeClient.forEach(
                reservation -> {
                    reservation.setClient(null);
                    reservationService.save(reservation);
                }
        );

        clientRepository.deleteById(id);
    }


    public ClientAvecReservationDto findClientWithReservation(Integer id) {
        // On récupère le client choisi
        Client client = this.findById(id);
        // On récupère la liste de ces réservations
        List<Reservation> reservationDuClient= reservationService.findAllByClientId(id);

        ClientAvecReservationDto clientAvecReservationDto = new ClientAvecReservationDto();

        clientAvecReservationDto.setId(client.getId());
        clientAvecReservationDto.setNom(client.getNom());
        clientAvecReservationDto.setPhoneNumber(client.getPhoneNumber());

        clientAvecReservationDto.setReservation(
                reservationDuClient.stream()
                        .map(
                                reservation -> {
                                    ReservationDto reservationDto = new ReservationDto();
                                    reservationDto.setId(reservation.getId());
                                    reservationDto.setCreneauH(reservation.getCreneauH());
                                    return reservationDto;
                                }
                        )
                        .toList()
        );

        return clientAvecReservationDto;
    }

    public List<Reservation> findReservationByClientId(Integer id) {
        return reservationService.findAllByClientId(id);
    }
}
