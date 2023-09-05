package com.athletereview.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.athletereview.api.dto.ReviewDto;
import com.athletereview.api.repository.ReviewRepository;
import com.athletereview.api.service.ReviewService;

public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;
	
	@Autowired
	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	@Override
	public ReviewDto createReview(int athleteId, ReviewDto reviewDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewDto> getReviewByAthleteId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReviewDto getReviewById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReviewDto updateReview(int athleteId, int reviewId, ReviewDto reviewDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReview(int athleteId, int reviewId) {
		// TODO Auto-generated method stub
		
	}

}
