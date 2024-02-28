package fr.cda.restaurant.menu;

import fr.cda.restaurant.exceptions.BadRequestException;
import fr.cda.restaurant.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository
    ) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public Menu save(Menu menu) throws BadRequestException {
        verifyMenu(menu);

        return menuRepository.save(menu);
    }

    private static void verifyMenu(Menu menu) {
        List<String> erreurs = new ArrayList<>();

        if (menu.getNom() == null) {
            erreurs.add("Le nom du menu est obligatoire");
        }

        if (menu.getRestaurant() == null) {
            erreurs.add("Le restaurant est obligatoire");
        }

        if (menu.getPrix() == 0) {
            erreurs.add("Le prix du menu est obligatoire et supérieur à 0");
        }

        if (menu.getEntree() == null) {
            erreurs.add("L'entrée du menu est obligatoire");
        }

        if (menu.getPlat() == null) {
            erreurs.add("Le plat du menu est obligatoire");
        }

        if (menu.getDessert() == null) {
            erreurs.add("Le dessert du menu est obligatoire");
        }

        if (menu.getBoisson() == null) {
            erreurs.add("La boisson du menu est obligatoire");
        }

        if (!erreurs.isEmpty()) {
            throw new BadRequestException(erreurs);
        }
    }

    public Menu findById(Integer id) {
        return menuRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Aucun menu avec l'ID " + id)
                );
    }

    public void deleteById(Integer id) {
        Menu menu = this.findById(id);
        menuRepository.delete(menu);
    }

    public Menu update(Menu menu, Integer id) {
        if (!menuRepository.existsById(id)) {
            throw new NotFoundException("Aucun menu avec l'ID " + id);
        }
        menu.setId(id);
        return menuRepository.save(menu);
    }

    public Menu findByNom(String nom) {
        return menuRepository.findByNom(nom)
                .orElseThrow(
                        () -> new NotFoundException("Aucun menu avec le nom " + nom)
                );
    }

    public List<Menu> findAllByRestaurantId(Integer id) {
        return menuRepository.findAllByRestaurantId(id)
                .orElseThrow(() -> new NotFoundException("Aucun menu trouvé avec le restaurant ID " + id));
    }

    public Optional<List<Menu>> findAllByRestaurantName(String nomRestaurant) {
        return Optional.ofNullable(menuRepository.findAllByRestaurantName(nomRestaurant)
                .orElseThrow(() -> new NotFoundException("Aucun menu trouvé avec le restaurant nom " + nomRestaurant)));
    }
}
