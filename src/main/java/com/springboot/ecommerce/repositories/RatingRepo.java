package com.springboot.ecommerce.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ecommerce.models.Rating;

@Repository
public interface RatingRepo extends MongoRepository<Rating, Object>{

	List<Rating> findByBookId(String book_id);

	List<Rating> findByUserId(String user_id);

	List<Rating> findByRating(String rating);

}
