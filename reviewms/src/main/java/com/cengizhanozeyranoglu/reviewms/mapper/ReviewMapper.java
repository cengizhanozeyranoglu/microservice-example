package com.cengizhanozeyranoglu.reviewms.mapper;

import com.cengizhanozeyranoglu.reviewms.dto.DtoReview;
import com.cengizhanozeyranoglu.reviewms.entity.Review;

public class ReviewMapper {

    public static DtoReview toDto(Review review) {
        DtoReview dto = DtoReview.builder()
                .title(review.getTitle())
                .description(review.getDescription())
                .rating(review.getRating())
                .companyId(review.getCompanyId())
                .build();
        return dto;
    }

    public static Review toReview(DtoReview dto){
        Review review = Review.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .rating(dto.getRating())
                .companyId(dto.getCompanyId())
                .build();
        return review;
    }
}
