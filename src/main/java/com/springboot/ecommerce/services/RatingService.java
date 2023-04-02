package com.springboot.ecommerce.services;

import java.util.List;

import com.springboot.ecommerce.models.Rating;

public interface RatingService {

	List<Rating> getAllRatings();

	List<Rating> getRatingsByBookId(String book_id);

	List<Rating> getRatingsByUserId(String user_id);

	List<Rating> getRatingsRating(String rating);

}
