package com.springboot.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ecommerce.models.Rating;
import com.springboot.ecommerce.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@GetMapping
	public List<Rating> getAllRatings(){
		return ratingService.getAllRatings();
	}
	
	@GetMapping("/book_id/{book_id}")
	public List<Rating> getRatingsByBookId(@PathVariable String book_id){
		return ratingService.getRatingsByBookId(book_id);
	}
	
	@GetMapping("/user_id/{user_id}")
	public List<Rating> getRatingsByUserId(@PathVariable String user_id){
		return ratingService.getRatingsByUserId(user_id);
	}
	
	@GetMapping("/rating/{rating}")
	public List<Rating> getRatingsByRating(@RequestParam String rating){
		return ratingService.getRatingsRating(rating);
	}
}
