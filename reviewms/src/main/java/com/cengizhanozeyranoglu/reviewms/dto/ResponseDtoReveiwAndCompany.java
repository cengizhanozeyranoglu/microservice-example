package com.cengizhanozeyranoglu.reviewms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDtoReveiwAndCompany {

    @JsonProperty("company")
    private DtoCompany dtoCompany;

    @JsonProperty("review")
    private List<DtoReview> dtoReview;
}
