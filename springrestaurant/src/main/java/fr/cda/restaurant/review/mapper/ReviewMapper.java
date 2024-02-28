package fr.cda.restaurant.review.mapper;

import fr.cda.restaurant.review.Review;
import fr.cda.restaurant.review.dto.ReviewCompletDto;
import fr.cda.restaurant.review.dto.ReviewReduitDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    public fr.cda.restaurant.review.mapper.ReviewMapper INSTANCE = Mappers.getMapper(fr.cda.restaurant.review.mapper.ReviewMapper.class);

    public ReviewCompletDto toReviewComplet(Review review);
    public List<ReviewCompletDto> toReviewComplet (List<Review> reviews);

    public ReviewReduitDto toReviewReduit (Review review);

    public List<ReviewReduitDto> toReviewReduit (List<Review> reviews);
}
