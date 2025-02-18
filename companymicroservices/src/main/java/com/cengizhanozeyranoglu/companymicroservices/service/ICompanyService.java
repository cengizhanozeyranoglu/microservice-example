package com.cengizhanozeyranoglu.companymicroservices.service;

import com.cengizhanozeyranoglu.companymicroservices.dto.DtoCompany;

import java.util.List;

public interface ICompanyService {

    public List<DtoCompany> getCompanyList();

    public DtoCompany createCompany(DtoCompany dtoCompany);

    public DtoCompany updateCompany (Long id, DtoCompany dtoCompany);

    public DtoCompany getCompanyById(Long id);

    public boolean deleteCompanyById(Long id);
}
