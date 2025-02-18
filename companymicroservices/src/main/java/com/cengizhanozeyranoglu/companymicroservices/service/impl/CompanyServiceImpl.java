package com.cengizhanozeyranoglu.companymicroservices.service.impl;

import com.cengizhanozeyranoglu.companymicroservices.dto.DtoCompany;
import com.cengizhanozeyranoglu.companymicroservices.entity.Company;
import com.cengizhanozeyranoglu.companymicroservices.mapper.CompanyMapper;
import com.cengizhanozeyranoglu.companymicroservices.repository.CompanyRepository;
import com.cengizhanozeyranoglu.companymicroservices.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements ICompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<DtoCompany> getCompanyList() {
        List<Company> companyList = companyRepository.findAll();

        List<DtoCompany> dtoCompanyList = new ArrayList<>();

        for (Company company : companyList) {
            dtoCompanyList.add(CompanyMapper.toDto(company));
        }
        return dtoCompanyList;
    }

    @Override
    public DtoCompany createCompany(DtoCompany dtoCompany) {
        Company company = CompanyMapper.toEntity(dtoCompany);
        Company savedCompany = companyRepository.save(company);
        return CompanyMapper.toDto(savedCompany);
    }

    @Override
    public DtoCompany updateCompany(Long id, DtoCompany dtoCompany) {
        Optional<Company> optCompany = companyRepository.findById(id);
        if (optCompany.isPresent()) {
            Company company = optCompany.get();
            company.setName(dtoCompany.getName());
            company.setDescription(dtoCompany.getDescription());
            Company savedCompany = companyRepository.save(company);
            return CompanyMapper.toDto(savedCompany);
        }
        log.info("Company id {} not found ", id);
        return null;
    }

    @Override
    public DtoCompany getCompanyById(Long id) {
        Optional<Company> optCompany = companyRepository.findById(id);
        if (optCompany.isPresent()) {
            return CompanyMapper.toDto(optCompany.get());
        }
        log.info("Company id {} not found ", id);
        return null;
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        Optional<Company> optCompany = companyRepository.findById(id);
        if (optCompany.isPresent()) {
            companyRepository.delete(optCompany.get());
            return true;
        }
        log.info("Company id {} not found ", id);
        return false;
    }
}
