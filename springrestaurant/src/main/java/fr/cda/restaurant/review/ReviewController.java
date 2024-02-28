package fr.cda.restaurant.review;

import fr.cda.restaurant.menu.Menu;
import fr.cda.restaurant.menu.dto.MenuCompletDto;
import fr.cda.restaurant.menu.dto.MenuReduitDto;
import fr.cda.restaurant.menu.mapper.MenuMapper;
import fr.cda.restaurant.review.dto.ReviewCompletDto;
import fr.cda.restaurant.review.dto.ReviewReduitDto;
import fr.cda.restaurant.review.mapper.ReviewMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    public ReviewController(
             ReviewService reviewService,
             ReviewMapper reviewMapper
    ) {
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
    }

    @GetMapping
    public List<ReviewCompletDto> findAll() {
        return reviewMapper.toReviewComplet(reviewService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review save(@RequestBody Review review) {

        return reviewService.save(review);
    }

    @GetMapping("/{id}") // /review/1
    public ReviewCompletDto findById(@PathVariable Integer id) {
        Review review = reviewService.findById(id);

        return reviewMapper.toReviewComplet(review);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        reviewService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Review update(@RequestBody Review review, @PathVariable Integer id) {
        return reviewService.update(review, id);
    }

    @GetMapping("complet/{id}")
    public List<ReviewReduitDto> findAllByRestaurantId(@PathVariable Integer id) {
        return reviewMapper.toReviewReduit(reviewService.findAllByRestaurantId(id));
    }

}
