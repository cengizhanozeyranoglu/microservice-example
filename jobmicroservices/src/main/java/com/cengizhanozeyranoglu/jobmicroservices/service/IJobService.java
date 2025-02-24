package com.cengizhanozeyranoglu.jobmicroservices.service;

import com.cengizhanozeyranoglu.jobmicroservices.dto.DtoJob;
import com.cengizhanozeyranoglu.jobmicroservices.dto.DtoResponseCompanyAndJob;

import java.util.List;

public interface IJobService {

    public List<DtoJob> getJobsList();

    public DtoJob createJob(DtoJob dtoJob);

    public DtoJob updateJob(Long id, DtoJob dtoJob);

    public DtoJob getJobById(Long id);

    public boolean deleteJobById(Long id);

    public DtoResponseCompanyAndJob getJobAndCompanyById(Long jobId);
}
