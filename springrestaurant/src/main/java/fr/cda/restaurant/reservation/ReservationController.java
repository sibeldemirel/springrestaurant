package fr.cda.restaurant.reservation;

import fr.cda.restaurant.reservation.dto.ReservationCompletDto;
import fr.cda.restaurant.reservation.dto.ReservationReduitDto;
import fr.cda.restaurant.reservation.mapper.ReservationMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    private final ReservationMapper reservationMapper;

    public ReservationController(
            ReservationService reservationService,
            ReservationMapper reservationMapper
    ){
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    @GetMapping
    public List<ReservationCompletDto> findAll() {
        return reservationMapper.toReservationComplet(reservationService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {

        return reservationService.save(reservation);
    }

    @GetMapping("/{id}") // /reservation/1
    public ReservationCompletDto findById(@PathVariable Integer id) {
        Reservation reservation = reservationService.findById(id);

        return reservationMapper.toReservationComplet(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        reservationService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Reservation update(@RequestBody Reservation reservation, @PathVariable Integer id) {
        return reservationService.update(reservation, id);
    }

    @GetMapping("complet/{id}")
    public List<ReservationReduitDto> findAllByRestaurantId(@PathVariable Integer id) {
        return reservationMapper.toReservationReduit(reservationService.findAllByRestaurantId(id));
    }
}
