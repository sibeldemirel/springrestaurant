package fr.cda.restaurant.review;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> findAll() {
        return reviewService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Review save(@RequestBody Review review){
        return reviewService.save(review);
    }

}
