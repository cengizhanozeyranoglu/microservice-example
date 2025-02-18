package com.cengizhanozeyranoglu.jobmicroservices.service;

import com.cengizhanozeyranoglu.jobmicroservices.dto.DtoJob;

import java.util.List;

public interface IJobService {

    public List<DtoJob> getJobsList();

    public DtoJob createJob(DtoJob dtoJob);

    public DtoJob updateJob(Long id, DtoJob dtoJob);

    public DtoJob getJobById(Long id);

    public boolean deleteJobById(Long id);
}
