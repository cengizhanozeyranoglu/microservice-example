package com.cengizhanozeyranoglu.jobmicroservices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoResponseCompanyAndJob {

    @JsonProperty("job")
    private DtoJob dtoJob;

    @JsonProperty("company")
    private DtoCompany dtoCompany;
}
