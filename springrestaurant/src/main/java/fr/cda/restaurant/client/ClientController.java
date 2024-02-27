package fr.cda.restaurant.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;
    private final ReservationMapper reservationMapper;

    public ClientController(
            ClientService clientService,
            ReservationMapper reservationMapper) {
        this.clientService = clientService;
        this.reservationMapper= reservationMapper;
    }

    @GetMapping
    public List<Client> findAll(){
        return clientService.findAll();
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
    clientService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }
    @PutMapping
    public Client update(@RequestBody Client client){
        return clientService.save(client);
    }
    @DeleteMapping
    public Client delete(@RequestBody Client client){
        return clientService.delete(client);
    }



}
