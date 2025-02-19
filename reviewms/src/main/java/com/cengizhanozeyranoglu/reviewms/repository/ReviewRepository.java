package com.cengizhanozeyranoglu.reviewms.repository;

import com.cengizhanozeyranoglu.reviewms.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
}
