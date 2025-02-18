package com.cengizhanozeyranoglu.companymicroservices.controller.impl;

import com.cengizhanozeyranoglu.companymicroservices.controller.ICompanyController;
import com.cengizhanozeyranoglu.companymicroservices.dto.DtoCompany;
import com.cengizhanozeyranoglu.companymicroservices.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/companies")
@RequiredArgsConstructor
public class CompanyControllerImpl implements ICompanyController {

    private final ICompanyService companyService;

    @Override
    @GetMapping(path = "/getCompanies")
    public ResponseEntity<List<DtoCompany>> getAllCompanies() {

        List<DtoCompany> companies = companyService.getCompanyList();
        return companies.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(companies);
    }

    @Override
    @PostMapping(path = "/createCompany")
    public ResponseEntity<DtoCompany> createCompany(@RequestBody DtoCompany dtoCompany) {
        return ResponseEntity.ok(companyService.createCompany(dtoCompany));
    }

    @Override
    @PutMapping(path = "/updateCompany/{id}")
    public ResponseEntity<DtoCompany> updateCompany(@PathVariable(name = "id") Long id, @RequestBody DtoCompany dtoCompany) {
        DtoCompany company = companyService.updateCompany(id, dtoCompany);
        if (company == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(company);
    }

    @Override
    @GetMapping(path = "/getCompany/{id}")
    public ResponseEntity<DtoCompany> getCompanyById(@PathVariable(name = "id") Long id) {
        DtoCompany company = companyService.getCompanyById(id);
        if (company == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(company);
    }

    @Override
    @DeleteMapping(path = "/deleteCompany/{id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable(name = "id") Long id) {
        boolean isDeleted = companyService.deleteCompanyById(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
