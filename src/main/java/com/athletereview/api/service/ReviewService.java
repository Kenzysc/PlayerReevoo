package com.athletereview.api.service;

import java.util.List;

import com.athletereview.api.dto.ReviewDto;

public interface ReviewService {
	
	ReviewDto createReview(int athleteId, ReviewDto reviewDto);
	
	List<ReviewDto> getReviewByAthleteId(int id);
	
	ReviewDto getReviewById(int id);
	
	ReviewDto updateReview(int athleteId, int reviewId, ReviewDto reviewDto);
	
	void deleteReview(int athleteId, int reviewId);

}
