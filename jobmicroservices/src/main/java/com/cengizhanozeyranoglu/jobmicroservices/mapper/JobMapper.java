package com.cengizhanozeyranoglu.jobmicroservices.mapper;

import com.cengizhanozeyranoglu.jobmicroservices.dto.DtoJob;
import com.cengizhanozeyranoglu.jobmicroservices.entity.Job;

public class JobMapper {

    public static DtoJob toDto(Job job) {
        DtoJob dtoJob = DtoJob.builder()
                .tittle(job.getTittle())
                .description(job.getDescription())
                .minSalary(job.getMinSalary())
                .maxSalary(job.getMaxSalary())
                .location(job.getLocation())
                .companyId(job.getCompanyId())
                .build();
        return dtoJob;

    }

    public static Job toEntity(DtoJob dtoJob) {
        Job job = Job.builder()
                .tittle(dtoJob.getTittle())
                .description(dtoJob.getDescription())
                .minSalary(dtoJob.getMinSalary())
                .maxSalary(dtoJob.getMaxSalary())
                .location(dtoJob.getLocation())
                .companyId(dtoJob.getCompanyId())
                .build();
        return job;
    }
}
