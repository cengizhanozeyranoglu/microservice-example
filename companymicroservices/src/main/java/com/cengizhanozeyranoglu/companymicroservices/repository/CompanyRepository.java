package com.cengizhanozeyranoglu.companymicroservices.repository;

import com.cengizhanozeyranoglu.companymicroservices.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
