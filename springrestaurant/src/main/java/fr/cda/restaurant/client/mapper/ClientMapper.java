package fr.cda.restaurant.client.mapper;

import fr.cda.restaurant.client.Client;
import fr.cda.restaurant.client.dto.ClientCompletDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    public fr.cda.restaurant.client.mapper.ClientMapper INSTANCE = Mappers.getMapper(fr.cda.restaurant.client.mapper.ClientMapper.class);

    public ClientCompletDto toClientComplet(Client client);

    public List<ClientCompletDto> toClientComplet (List<Client> clients);

}
