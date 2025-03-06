package com.cengizhanozeyranoglu.reviewms.service.impl;

import com.cengizhanozeyranoglu.reviewms.client.ICompanyClient;
import com.cengizhanozeyranoglu.reviewms.dto.DtoCompany;
import com.cengizhanozeyranoglu.reviewms.dto.DtoReview;
import com.cengizhanozeyranoglu.reviewms.dto.ResponseDtoReveiwAndCompany;
import com.cengizhanozeyranoglu.reviewms.entity.Review;
import com.cengizhanozeyranoglu.reviewms.exception.CompanyNotFoundExcepiton;
import com.cengizhanozeyranoglu.reviewms.mapper.ReviewMapper;
import com.cengizhanozeyranoglu.reviewms.messaging.MessagePublisher;
import com.cengizhanozeyranoglu.reviewms.repository.ReviewRepository;
import com.cengizhanozeyranoglu.reviewms.service.IReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements IReviewService {

    private final ReviewRepository reviewRepo;

    private final ICompanyClient companyClient;

    private final MessagePublisher messagePublisher;

    @CacheEvict(value = "reviews", allEntries = true)
    @Override
    public DtoReview createReview(DtoReview dtoReview) {
        Review review = ReviewMapper.toReview(dtoReview);
        Review savedReview = reviewRepo.save(review);
        messagePublisher.publish(dtoReview.getCompanyId());
        DtoReview dtoRev = ReviewMapper.toDto(savedReview);
        return dtoRev;
    }

    @CacheEvict(value = "reviews", key = "#id", allEntries = true)
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
    public ResponseDtoReveiwAndCompany getReviewsByCompanyId(Long companyId) {
        ResponseDtoReveiwAndCompany response = new ResponseDtoReveiwAndCompany();
        List<DtoReview> dtoReviews = reviewRepo.findByCompanyId(companyId)
                .orElse(Collections.emptyList())
                .stream()
                .map(ReviewMapper::toDto)
                .collect(Collectors.toList());
        response.setDtoReview(dtoReviews);
        if (dtoReviews.isEmpty()) {
            log.info("No reviews found for companyId {}", companyId);
        }
        try {
            DtoCompany dtoCompany = companyClient.getCompanyById(companyId);
            response.setDtoCompany(dtoCompany);
        } catch (CompanyNotFoundExcepiton e) {
            log.info("Company id {} not found", companyId);
            throw new CompanyNotFoundExcepiton("Company not found for ID" + companyId);
        }
        return response;
    }

    @Cacheable(value = "reviews", key = "#root.methodName", unless = "#result==null")
    @Override
    public List<DtoReview> getReviewList() {
        List<Review> reviewList = reviewRepo.findAll();
        List<DtoReview> dtoReviews = reviewList.stream()
                .map(ReviewMapper::toDto)
                .collect(Collectors.toList());
        return dtoReviews;
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
