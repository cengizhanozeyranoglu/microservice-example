package com.cengizhanozeyranoglu.jobmicroservices.service.impl;

import com.cengizhanozeyranoglu.jobmicroservices.dto.DtoJob;
import com.cengizhanozeyranoglu.jobmicroservices.entity.Job;
import com.cengizhanozeyranoglu.jobmicroservices.mapper.JobMapper;
import com.cengizhanozeyranoglu.jobmicroservices.repository.JobRepository;
import com.cengizhanozeyranoglu.jobmicroservices.service.IJobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class JobServiceImpl implements IJobService {

    private final JobRepository jobRepository;

    @Override
    public List<DtoJob> getJobsList() {

        List<Job> dbJob = jobRepository.findAll();
        List<DtoJob> dtoJobsList = new ArrayList<>();
        for (Job job : dbJob) {
            dtoJobsList.add(JobMapper.toDto(job));
        }
        return dtoJobsList;
    }

    @Override
    public DtoJob createJob(DtoJob dtoJob) {

        Job job = JobMapper.toEntity(dtoJob);
        Job savedJob = jobRepository.save(job);
        return JobMapper.toDto(savedJob);

    }

    @Override
    public DtoJob updateJob(Long id, DtoJob dtoJob) {

        Optional<Job> optJob = jobRepository.findById(id);
        if (optJob.isPresent()) {
            Job job = optJob.get();
            job.setDescription(dtoJob.getDescription());
            job.setLocation(dtoJob.getLocation());
            job.setTittle(dtoJob.getTittle());
            job.setMinSalary(dtoJob.getMinSalary());
            job.setMaxSalary(dtoJob.getMaxSalary());
            Job savedJob = jobRepository.save(job);
            return JobMapper.toDto(savedJob);
        } else log.info("Job with id {} not found", id);
        return null;
    }

    @Override
    public DtoJob getJobById(Long id) {
        Optional<Job> optJob = jobRepository.findById(id);
        if (optJob.isEmpty()) {
            log.info("Job with id {} not found", id);
            return null;
        }
        return JobMapper.toDto(optJob.get());

    }

    @Override
    public boolean deleteJobById(Long id) {
        Optional<Job> optJob = jobRepository.findById(id);
        if (optJob.isPresent()) {
            jobRepository.delete(optJob.get());
            return true;
        } else log.info("Job with id {} not found", id);
        return false;
    }
}
