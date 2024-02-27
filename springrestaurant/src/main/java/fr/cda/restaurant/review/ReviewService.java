package fr.cda.restaurant.review;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review save(Review review){
        return reviewRepository.save(review);
    }


    public List<Review> findAll(){
        return reviewRepository.findAll();
    }

    public Review update(Review review, Integer id){
        review.setId(id);
        this.findById(id);
        return reviewRepository.save(review);
    }

    public void deleteById(Integer id){
        reviewRepository.findById(id);
    }
}
