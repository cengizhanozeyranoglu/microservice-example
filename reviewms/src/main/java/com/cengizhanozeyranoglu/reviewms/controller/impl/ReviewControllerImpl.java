package com.cengizhanozeyranoglu.reviewms.controller.impl;

import com.cengizhanozeyranoglu.reviewms.controller.IReviewController;
import com.cengizhanozeyranoglu.reviewms.dto.DtoReview;
import com.cengizhanozeyranoglu.reviewms.service.IReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reviews")
@RequiredArgsConstructor
public class ReviewControllerImpl implements IReviewController {

    private final IReviewService reviewService;

    @Override
    @PostMapping(path = "/createReview")
    public ResponseEntity<DtoReview> createReview(@RequestBody DtoReview review) {
        return ResponseEntity.ok(reviewService.createReview(review));
    }

    @Override
    @PutMapping(path = "/updateReview/{id}")
    public ResponseEntity<DtoReview> updateReview(@RequestBody DtoReview dtoReview, @PathVariable String id) {
        DtoReview review = reviewService.updateReview(dtoReview, id);
        return review != null ? ResponseEntity.ok(review) : ResponseEntity.notFound().build();
    }

    @Override
    @GetMapping(path = "getReviews/{companyId}")
    public ResponseEntity<List<DtoReview>> getReviewByCompanyId(@PathVariable Long companyId) {
        List<DtoReview> dtoReviewList = reviewService.getReviewsByCompanyId(companyId);
        return dtoReviewList.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(dtoReviewList);
    }

    @Override
    @GetMapping(path = "/getReview/{id}")
    public ResponseEntity<DtoReview> getReviewById(@PathVariable String id) {
        DtoReview dtoReview = reviewService.getReviewById(id);
        return dtoReview != null ? ResponseEntity.ok(dtoReview) : ResponseEntity.notFound().build();

    }

    @Override
    @DeleteMapping(path = "/deleteReview/{id}")
    public ResponseEntity<Void> deleteReviewById(@PathVariable String id) {
        return reviewService.deleteReview(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
