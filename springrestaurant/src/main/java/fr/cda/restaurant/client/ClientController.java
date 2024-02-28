package fr.cda.restaurant.client;

import fr.cda.restaurant.client.dto.ClientCompletDto;
import fr.cda.restaurant.client.mapper.ClientMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;
    public ClientController(
            ClientService clientService,
            ClientMapper clientMapper
    ) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;

    }

    @GetMapping
    public List<ClientCompletDto> findAll() {
        return clientMapper.toClientComplet(clientService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {

        return clientService.save(client);
    }

    @GetMapping("/{id}") // /menu/1
    public ClientCompletDto findById(@PathVariable Integer id) {
        Client client = clientService.findById(id);

        return clientMapper.toClientComplet(client);
    }

    @PutMapping("/{id}")
    public Client update(@RequestBody Client client, @PathVariable Integer id) {
        return clientService.update(client, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        clientService.deleteById(id);
    }

}
