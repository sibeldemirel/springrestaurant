package fr.cda.restaurant.menu.mapper;

import fr.cda.restaurant.menu.Menu;
import fr.cda.restaurant.menu.dto.MenuCompletDto;
import fr.cda.restaurant.menu.dto.MenuReduitDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper (componentModel = "spring")
public interface MenuMapper {

    public MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);

    public MenuCompletDto toMenuComplet(Menu menu);

    public List<MenuCompletDto> toMenuComplet (List<Menu> menus);
    public MenuReduitDto toFilmReduit(Menu menu);

    public List<MenuReduitDto> toMenuReduit (List<Menu> menus);

}
