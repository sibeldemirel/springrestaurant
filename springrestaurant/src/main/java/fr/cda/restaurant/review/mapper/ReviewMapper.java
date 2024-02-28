package fr.cda.restaurant.review.mapper;

import fr.cda.restaurant.review.Review;
import fr.cda.restaurant.review.dto.ReviewCompletDto;
import fr.cda.restaurant.review.dto.ReviewReduitDto;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface ReviewMapper {
    public fr.cda.restaurant.review.mapper.ReviewMapper INSTANCE = Mappers.getMapper(fr.cda.restaurant.review.mapper.ReviewMapper.class);

    public ReviewCompletDto toReviewCompletDto(List<Review> reviews);

    public ReviewReduitDto toReviewReduitDto(List<Review> reviews);
}
