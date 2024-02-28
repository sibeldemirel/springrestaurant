package fr.cda.restaurant.reservation;

import fr.cda.restaurant.client.ClientService;
import fr.cda.restaurant.restaurant.Restaurant;
import fr.cda.restaurant.exceptions.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
        return reservationRepository.findById(id).orElseThrow(() ->
    new NotFoundException ("Aucun reservation connue avec cey ID"+id));
    }


    public void deleteById(Integer id){
        this.findById(id);
        reservationRepository.deleteById(id);
    }

    public List<Reservation> findALl(){
        return reservationRepository.findAll();
    }
    public List<Reservation> findAllByCreneau (LocalDate creneauH){
        LocalDateTime creneauHRecherche =LocalDateTime.of(LocalDate.parse(creneauH), LocalDateTime.MIN.toLocalTime());
        LocalDateTime creneauHRechercheMax= LocalDateTime.of(LocalDate.parse(creneauH),LocalDateTime.MAX.toLocalTime());
        return reservationRepository.findAllByCreneau(creneauHRecherche, creneauHRechercheMax);
    }
    public Reservation save(Reservation reservation){
        verifyReservation(reservation);
        reservation.setClient(clientService.findById(reservation.getClient().getId()));
        reservation.setCreneauH(reservation.getCreneauH());
        reservation.setNbInvite(reservation.getNbInvite());
        reservation.setAnniv(reservation.isAnniv());
        return reservationRepository.save(reservation);
    }

    private void verifyReservation(Reservation reservation) {
    List<String> errors= new ArrayList<>();

    if (reservation.getNbInvite() > Restaurant.couvertsDispo){
        errors.add("Le nombre d'invite dépasse le nombre de place disonible");
    }
    }

}