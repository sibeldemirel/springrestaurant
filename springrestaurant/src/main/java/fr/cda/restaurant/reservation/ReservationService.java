package fr.cda.restaurant.reservation;

import fr.cda.restaurant.client.ClientService;
import fr.cda.restaurant.exceptions.NotFoundException;

public class ReservationService {
    private final ReservationRepository reservationRepository;
    private ClientService clientService;
    public ReservationService(
            ReservationRepository reservationRepository,
            ClientService clientService) {
        this.reservationRepository = reservationRepository;
        this.clientService = clientService;
    }

    public Reservation findById(Integer id){
        return reservationRepository.findById(id).orElseThro(() ->
    new NotFoundException ("Aucun reservation connue avec cey ID"+id));
    }

    public void deleteById(Integer id){
        this.findById(id);
        reservationRepository.deleteById(id);
    }



}