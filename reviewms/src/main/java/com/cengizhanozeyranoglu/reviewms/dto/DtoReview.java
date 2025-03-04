package com.cengizhanozeyranoglu.reviewms.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DtoReview  {

    private String title;

    private String description;

    private Double rating;

    private Long companyId;
}
