package com.cengizhanozeyranoglu.companymicroservices.mapper;

import com.cengizhanozeyranoglu.companymicroservices.dto.DtoCompany;
import com.cengizhanozeyranoglu.companymicroservices.entity.Company;


public class CompanyMapper {

    public static DtoCompany toDto(Company company) {
        DtoCompany dtoCompany = DtoCompany.builder()
                .name(company.getName())
                .description(company.getDescription())
                .build();
        return dtoCompany;
    }

    public static Company toEntity(DtoCompany dtoCompany) {
        Company company = Company.builder()
                .name(dtoCompany.getName())
                .description(dtoCompany.getDescription())
                .build();
        return company;

    }
}
