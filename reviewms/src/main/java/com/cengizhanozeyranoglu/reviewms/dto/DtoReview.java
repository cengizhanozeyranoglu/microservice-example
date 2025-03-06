package com.cengizhanozeyranoglu.reviewms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DtoReview implements Serializable {

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("rating")
    private Double rating;

    @JsonProperty("companyId")
    private Long companyId;

    @Override
    public String toString() {
        return "DtoReview {\n" +
                "title='" + title + ",\n" +
                "description='" + description + ",\n" +
                "rating=" + rating + ",\n" +
                "companyId=" + companyId + ",\n" +
                "}";
    }
}
