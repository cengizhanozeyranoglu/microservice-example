package com.cengizhanozeyranoglu.reviewms.service.impl;

import com.cengizhanozeyranoglu.reviewms.dto.DtoReview;
import com.cengizhanozeyranoglu.reviewms.entity.Review;
import com.cengizhanozeyranoglu.reviewms.mapper.ReviewMapper;
import com.cengizhanozeyranoglu.reviewms.repository.ReviewRepository;
import com.cengizhanozeyranoglu.reviewms.service.IReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements IReviewService {

    private final ReviewRepository reviewRepo;


    @Override
    public DtoReview createReview(DtoReview dtoReview) {
        Review review = ReviewMapper.toReview(dtoReview);
        Review savedReview = reviewRepo.save(review);
        DtoReview dtoRev = ReviewMapper.toDto(savedReview);
        return dtoRev;
    }
}
