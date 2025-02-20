package com.cengizhanozeyranoglu.reviewms.service.impl;

import com.cengizhanozeyranoglu.reviewms.dto.DtoReview;
import com.cengizhanozeyranoglu.reviewms.entity.Review;
import com.cengizhanozeyranoglu.reviewms.mapper.ReviewMapper;
import com.cengizhanozeyranoglu.reviewms.repository.ReviewRepository;
import com.cengizhanozeyranoglu.reviewms.service.IReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
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

    @Override
    public DtoReview updateReview(DtoReview dtoReview, String id) {
        return reviewRepo.findById(id)
                .map(review -> {
                    review.setRating(dtoReview.getRating());
                    review.setTitle(dtoReview.getTitle());
                    review.setDescription(dtoReview.getDescription());
                    review.setCompanyId(dtoReview.getCompanyId());
                    return ReviewMapper.toDto(reviewRepo.save(review));
                })
                .orElseGet(() -> {
                    log.info("Review id {} not found", id);
                    return null;
                });
    }

    @Override
    public List<DtoReview> getReviewsByCompanyId(Long companyId) {
        return reviewRepo.findByCompanyId(companyId)
                .stream()
                .map(ReviewMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoReview getReviewById(String id) {
        return reviewRepo.findById(id)
                .map(ReviewMapper::toDto)
                .orElseGet(() -> {
                    log.info("Review with id {} not found.", id);
                    return null;
                });
    }

    @Override
    public boolean deleteReview(String id) {
        Optional<Review> optReview = reviewRepo.findById(id);
        if (optReview.isPresent()) {
            reviewRepo.delete(optReview.get());
            return true;
        } else {
            log.info("Review with id {} not found", id);
            return false;
        }
    }
}
