package com.cengizhanozeyranoglu.reviewms.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {

    @Id
    private String id;

    private String title;

    private String description;

    private Double rating;

    private Long companyId;


}
