package fr.cda.restaurant.restaurant.mapper;

import fr.cda.restaurant.menu.Menu;
import fr.cda.restaurant.menu.dto.MenuCompletDto;
import fr.cda.restaurant.menu.dto.MenuReduitDto;
import fr.cda.restaurant.restaurant.Restaurant;
import fr.cda.restaurant.restaurant.dto.RestaurantCompletDto;
import fr.cda.restaurant.restaurant.dto.RestaurantReduitDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    public fr.cda.restaurant.restaurant.mapper.RestaurantMapper INSTANCE = Mappers.getMapper(fr.cda.restaurant.restaurant.mapper.RestaurantMapper.class);

    public RestaurantCompletDto toRestaurantComplet(Restaurant restaurant);

    public List<RestaurantCompletDto> toRestaurantComplet (List<Restaurant> restaurants);
    public RestaurantReduitDto toRestaurantReduit(Restaurant restaurant);

    public List<RestaurantReduitDto> toRestaurantReduit (List<Restaurant> restaurants);

}
