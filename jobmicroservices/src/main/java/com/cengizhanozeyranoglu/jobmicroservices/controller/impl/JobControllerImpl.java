package com.cengizhanozeyranoglu.jobmicroservices.controller.impl;

import com.cengizhanozeyranoglu.jobmicroservices.controller.IJobController;
import com.cengizhanozeyranoglu.jobmicroservices.dto.DtoJob;
import com.cengizhanozeyranoglu.jobmicroservices.dto.DtoResponseCompanyAndJob;
import com.cengizhanozeyranoglu.jobmicroservices.service.IJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/jobs")
@RequiredArgsConstructor
public class JobControllerImpl implements IJobController {

    private final IJobService jobService;

    @Override
    @GetMapping(path = "/getJobs")
    public ResponseEntity<List<DtoJob>> getJobsList() {
        List<DtoJob> jobs = jobService.getJobsList();
        return jobs.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(jobs);
    }

    @Override
    @PostMapping(path = "/createJob")
    public ResponseEntity<DtoJob> createJob(@RequestBody DtoJob dtoJob) {
        return ResponseEntity.ok(jobService.createJob(dtoJob));

    }

    @Override
    @PutMapping(path = "/updateJob/{id}")
    public ResponseEntity<DtoJob> updateJob(@RequestBody DtoJob dtoJob, @PathVariable(name = "id") Long id) {
        DtoJob updatedJob = jobService.updateJob(id, dtoJob);
        if (updatedJob == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedJob);
    }

    @Override
    @GetMapping(path = "/getJob/{id}")
    public ResponseEntity<DtoJob> getJobById(@PathVariable(name = "id") Long id) {
        DtoJob job = jobService.getJobById(id);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(job);
    }

    @Override
    @DeleteMapping(path = "/deleteJob/{id}")
    public ResponseEntity<Void> deleteJobById(@PathVariable(name = "id") Long id) {
        boolean isDeleted = jobService.deleteJobById(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping(path = "/getJobsWithCompany/{companyId}")
    public ResponseEntity<DtoResponseCompanyAndJob> getCompanyAndJobById(@PathVariable Long companyId) {
        DtoResponseCompanyAndJob response = jobService.getJobAndCompanyById(companyId);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
