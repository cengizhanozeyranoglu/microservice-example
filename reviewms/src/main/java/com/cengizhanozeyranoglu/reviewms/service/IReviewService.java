package com.cengizhanozeyranoglu.reviewms.service;

import com.cengizhanozeyranoglu.reviewms.dto.DtoReview;

import java.util.List;

public interface IReviewService {

    DtoReview createReview(DtoReview dtoReview);

    DtoReview updateReview(DtoReview dtoReview, String id);

    List<DtoReview> getReviewsByCompanyId(Long companyId);

    DtoReview getReviewById(String id);

    boolean deleteReview(String id);
}
