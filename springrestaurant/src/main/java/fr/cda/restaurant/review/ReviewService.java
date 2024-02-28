package fr.cda.restaurant.review;

import fr.cda.restaurant.exceptions.BadRequestException;
import fr.cda.restaurant.exceptions.NotFoundException;
import fr.cda.restaurant.menu.Menu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review save(Review review) throws BadRequestException {
        verifyReview(review);

        return reviewRepository.save(review);
    }

    private static void verifyReview(Review review) {
        List<String> erreurs = new ArrayList<>();

        if (review.getRestaurantName() == null) {
            erreurs.add("Le nom du restaurant est obligatoire");
        }

        if (review.getPseudo() == null) {
            erreurs.add("Le pseudo est obligatoire");
        }

        if (String.valueOf(review.getRating()).length() != 1) {
            erreurs.add("Le rating doit contenir 1 chiffre");
        }

        if (!erreurs.isEmpty()) {
            throw new BadRequestException(erreurs);
        }
    }

    public Review update(Review review, Integer id) {
        if (!reviewRepository.existsById(id)) {
            throw new NotFoundException("Aucun menu avec l'ID " + id);
        }
        review.setId(id);
        return reviewRepository.save(review);
    }

    public Review findById(Integer id) {
        return reviewRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Aucune review avec l'ID " + id)
                );
    }

    public void deleteById(Integer id) {
        Review review = this.findById(id);
        reviewRepository.delete(review);
    }

    public List<Review> findAllByRestaurantId(Integer id) {
        return reviewRepository.findAllByRestaurantId(id)
                .orElseThrow(() -> new NotFoundException("Aucune review trouvé avec le restaurant ID " + id));
    }

    public Optional<List<Review>> findAllByRestaurantName(String nomRestaurant) {
        return Optional.ofNullable(reviewRepository.findAllByRestaurantName(nomRestaurant)
                .orElseThrow(() -> new NotFoundException("Aucune review trouvé avec le restaurant nom " + nomRestaurant)));
    }

}



