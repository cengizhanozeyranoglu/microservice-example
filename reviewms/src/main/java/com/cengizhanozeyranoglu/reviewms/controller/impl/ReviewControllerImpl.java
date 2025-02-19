package com.cengizhanozeyranoglu.reviewms.controller.impl;

import com.cengizhanozeyranoglu.reviewms.controller.IReviewController;
import com.cengizhanozeyranoglu.reviewms.dto.DtoReview;
import com.cengizhanozeyranoglu.reviewms.service.IReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
