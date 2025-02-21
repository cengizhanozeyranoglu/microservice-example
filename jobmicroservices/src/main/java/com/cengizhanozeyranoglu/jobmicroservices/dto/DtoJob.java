package com.cengizhanozeyranoglu.jobmicroservices.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DtoJob {

    private String tittle;

    private String description;

    private String minSalary;

    private String maxSalary;

    private String location;

    private Long companyId;
}
