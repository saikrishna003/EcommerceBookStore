package com.springboot.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ecommerce.models.Rating;
import com.springboot.ecommerce.repositories.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepo ratingRepo;
	
	@Override
	public List<Rating> getAllRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingsByBookId(String book_id) {
		return ratingRepo.findByBookId(book_id);
	}

	@Override
	public List<Rating> getRatingsByUserId(String user_id) {
		return ratingRepo.findByUserId(user_id);
	}

	@Override
	public List<Rating> getRatingsRating(String rating) {
		return ratingRepo.findByRating(rating);
	}

}
