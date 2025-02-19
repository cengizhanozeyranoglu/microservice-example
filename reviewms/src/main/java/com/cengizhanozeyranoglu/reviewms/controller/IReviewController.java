package com.cengizhanozeyranoglu.reviewms.controller;

import com.cengizhanozeyranoglu.reviewms.dto.DtoReview;
import org.springframework.http.ResponseEntity;

public interface IReviewController {

    ResponseEntity<DtoReview> createReview(DtoReview review);
}
