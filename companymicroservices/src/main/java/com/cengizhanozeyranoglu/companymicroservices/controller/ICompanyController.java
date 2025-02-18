package com.cengizhanozeyranoglu.companymicroservices.controller;

import com.cengizhanozeyranoglu.companymicroservices.dto.DtoCompany;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICompanyController {

    public ResponseEntity<List<DtoCompany>> getAllCompanies();

    public ResponseEntity<DtoCompany> createCompany(DtoCompany dtoCompany);

    public ResponseEntity<DtoCompany> updateCompany(Long id, DtoCompany dtoCompany);

    public ResponseEntity<DtoCompany> getCompanyById(Long id);

    public ResponseEntity<Void> deleteCompanyById(Long id);
}
