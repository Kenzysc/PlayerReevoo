package com.athletereview.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athletereview.api.dto.ReviewDto;
import com.athletereview.api.service.ReviewService;

@RestController
@RequestMapping("/api/")
public class ReviewController {
	
	private ReviewService reviewService;
	
	@Autowired
	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	@PostMapping("/athlete/{athleteId}/review")
	public ResponseEntity<ReviewDto> createReview(@PathVariable(value = "athleteId") int athleteId,
												  @RequestBody ReviewDto reviewDto) {
		return null;
	}
	
	@GetMapping("/athlete/{athleteId}/{id}")
	public ResponseEntity<ReviewDto> getReviewsById(@PathVariable(value = "athleteId") int athleteId,
													@PathVariable(value = "id") int id) {
		return null;
	}
	
	@GetMapping("athlete/{athleteId}/reviews")
	public List<ReviewDto> getReviewsByPokemonId(@PathVariable(value = "athleteId") int athleteId) {
		return null;
	}
	
	@PutMapping("athlete/{athleteId}/{id}")
	public ResponseEntity<ReviewDto> updateReview(@PathVariable(value = "athleteId") int athleteId,
												  @PathVariable(value = "id") int id,
												  @RequestBody ReviewDto reviewDto) {
		return null;
	}
	
	@DeleteMapping("athlete/{athleteId}/reviews/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable(value = "athleteId") int athleteId,
											   @PathVariable(value = "id") int id) {
		return null;
	}
}
