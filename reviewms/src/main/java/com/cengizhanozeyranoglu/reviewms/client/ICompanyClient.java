package com.cengizhanozeyranoglu.reviewms.client;

import com.cengizhanozeyranoglu.reviewms.dto.DtoCompany;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "companymicroservices", url = "http://localhost:8081")
public interface ICompanyClient {

    @GetMapping(path = "/companies/getCompany/{companyId}")
    DtoCompany getCompanyById(@PathVariable Long companyId);
}
