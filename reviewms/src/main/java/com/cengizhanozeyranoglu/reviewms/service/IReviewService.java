package com.cengizhanozeyranoglu.reviewms.service;

import com.cengizhanozeyranoglu.reviewms.dto.DtoReview;
import com.cengizhanozeyranoglu.reviewms.dto.ResponseDtoReveiwAndCompany;

import java.util.List;

public interface IReviewService {

    DtoReview createReview(DtoReview dtoReview);

    DtoReview updateReview(DtoReview dtoReview, String id);

    ResponseDtoReveiwAndCompany getReviewsByCompanyId(Long companyId);

    List<DtoReview> getReviewList();

    DtoReview getReviewById(String id);

    boolean deleteReview(String id);
}
