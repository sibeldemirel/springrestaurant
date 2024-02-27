package fr.cda.restaurant.menu;

import fr.cda.restaurant.menu.dto.MenuCompletDto;
import fr.cda.restaurant.menu.dto.MenuReduitDto;
import fr.cda.restaurant.menu.mapper.MenuMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;
    private final MenuMapper menuMapper;

    public MenuController(
            MenuService menuService,
            MenuMapper menuMapper
    ) {
        this.menuService = menuService;
        this.menuMapper = menuMapper;
    }

    @GetMapping
    public List<MenuReduitDto> findAll() {
        return menuMapper.toMenuReduit(menuService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Menu save(@RequestBody Menu menu) {

        return menuService.save(menu);
    }

    @GetMapping("/{id}") // /menu/1
    public MenuCompletDto findById(@PathVariable Integer id) {
        Menu menu = menuService.findById(id);

        return menuMapper.toMenuComplet(menu);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        menuService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Menu update(@RequestBody Menu menu, @PathVariable Integer id) {
        return menuService.update(menu, id);
    }

    @GetMapping("/search") // /menu/search?nom=MenuEnfant
    public Menu findByNom(@RequestParam String nom) {
        return menuService.findByNom(nom);
    }

    @GetMapping("complet/{id}")
    public List<MenuCompletDto> findAllByRestaurantId(@PathVariable Integer id) {
        return menuMapper.toMenuComplet(menuService.findAllByRestaurantId(id));
    }

    @GetMapping("reduit/{id}")
    public List<MenuReduitDto> findAllReduitByRestaurantId(@PathVariable Integer id) {
        return menuMapper.toMenuReduit(menuService.findAllByRestaurantId(id));
    }

    @GetMapping("complet/{restaurantName}")
    public List<MenuCompletDto> findAllByRestaurantName(@PathVariable String restaurantName) {
        return menuMapper.toMenuComplet(menuService.findAllByRestaurantName(restaurantName).orElse(new ArrayList<>()));
    }

    @GetMapping("reduit/{restaurantName}")
    public List<MenuReduitDto> findAllReduitByRestaurantName(@PathVariable String restaurantName) {
        return menuMapper.toMenuReduit(menuService.findAllByRestaurantName(restaurantName).orElse(new ArrayList<>()));
    }
}
