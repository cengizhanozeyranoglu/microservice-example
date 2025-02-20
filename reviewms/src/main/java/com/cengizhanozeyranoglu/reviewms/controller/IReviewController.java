package com.cengizhanozeyranoglu.reviewms.controller;

import com.cengizhanozeyranoglu.reviewms.dto.DtoReview;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReviewController {

    ResponseEntity<DtoReview> createReview(DtoReview review);

    ResponseEntity<DtoReview> updateReview(DtoReview review, String id);

    ResponseEntity<List<DtoReview>> getReviewByCompanyId(Long companyId);

    ResponseEntity<DtoReview> getReviewById(String id);

    ResponseEntity<Void> deleteReviewById(String id);
}
