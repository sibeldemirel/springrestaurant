package fr.cda.restaurant.reservation;


import fr.cda.restaurant.client.Client;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> findById(){
        return reservationService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){reservationService.deleteById(id);
    }

    GetMapping
    public List<Reservation> findAllByCreneau(){return reservationService.findAllByCreneau()}


}
