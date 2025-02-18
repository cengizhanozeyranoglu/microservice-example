package com.cengizhanozeyranoglu.jobmicroservices.repository;

import com.cengizhanozeyranoglu.jobmicroservices.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
