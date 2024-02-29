package fr.cda.restaurant.reservation;

import fr.cda.restaurant.client.Client;
import fr.cda.restaurant.client.ClientService;
import fr.cda.restaurant.reservation.dto.ReservationCompletDto;
import fr.cda.restaurant.reservation.dto.ReservationReduitDto;
import fr.cda.restaurant.reservation.dto.ReservationRequestDto;
import fr.cda.restaurant.reservation.mapper.ReservationMapper;
import fr.cda.restaurant.restaurant.Restaurant;
import fr.cda.restaurant.restaurant.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    private final ClientService clientService;

    private final RestaurantService restaurantService;

    private final ReservationMapper reservationMapper;

    public ReservationController(
            ReservationService reservationService,
            ClientService clientService,
            RestaurantService restaurantService,
            ReservationMapper reservationMapper
    ){
        this.reservationService = reservationService;
        this.clientService = clientService;
        this.restaurantService = restaurantService;
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

    @PostMapping("/create")
    public ReservationCompletDto createReservation(@RequestBody ReservationRequestDto requestDto) {
        Client client = clientService.findOrCreateClient(requestDto.getNomClient(), requestDto.getTelephoneClient());

        Restaurant restaurant = restaurantService.findByNom(requestDto.getNomRestaurant());
        if (restaurant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant non trouvé");
        }

        if (restaurant.getCouvertsDispo() < requestDto.getNbInvite()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pas assez de couverts disponibles");
        }

        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setRestaurant(restaurant);
        reservation.setDateReservation(requestDto.getDateReservation());
        reservation.setNbInvite(requestDto.getNbInvite());
        reservation.setAnniv(requestDto.isAnniv());

        restaurant.setCouvertsDispo(restaurant.getCouvertsDispo() - requestDto.getNbInvite());

        Reservation savedReservation = reservationService.save(reservation);
        restaurantService.save(restaurant);

        return reservationMapper.toReservationComplet(savedReservation);
    }
}
