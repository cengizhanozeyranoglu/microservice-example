package com.cengizhanozeyranoglu.jobmicroservices.controller;

import com.cengizhanozeyranoglu.jobmicroservices.dto.DtoJob;
import com.cengizhanozeyranoglu.jobmicroservices.dto.DtoResponseCompanyAndJob;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IJobController {

    public ResponseEntity<List<DtoJob>> getJobsList();

    public ResponseEntity<DtoJob> createJob(DtoJob dtoJob);

    public ResponseEntity<DtoJob> updateJob (DtoJob dtoJob, Long id);

    public ResponseEntity<DtoJob> getJobById(Long id);

    public ResponseEntity<Void> deleteJobById(Long id);

    public ResponseEntity<DtoResponseCompanyAndJob> getCompanyAndJobById(Long companyId);

}
