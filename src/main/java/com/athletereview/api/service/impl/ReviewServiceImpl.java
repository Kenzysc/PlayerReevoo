package com.athletereview.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athletereview.api.dto.ReviewDto;
import com.athletereview.api.exceptions.AthleteNotFoundException;
import com.athletereview.api.exceptions.ReviewNotFoundException;
import com.athletereview.api.models.Athlete;
import com.athletereview.api.models.Review;
import com.athletereview.api.repository.AthleteRepository;
import com.athletereview.api.repository.ReviewRepository;
import com.athletereview.api.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;
	private AthleteRepository athleteRepository;
	
	@Autowired
	public ReviewServiceImpl(ReviewRepository reviewRepository, AthleteRepository athleteRepository) {
		this.reviewRepository = reviewRepository;
		this.athleteRepository = athleteRepository;
	}

	@Override
	public ReviewDto createReview(int athleteId, ReviewDto reviewDto) {
		Review review = mapToEntity(reviewDto);
		
		Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(() -> new AthleteNotFoundException("Athlete with associated review not found"));
		
		review.setAthlete(athlete);
		
		Review newReview =  reviewRepository.save(review);
		
		return mapToDto(newReview);
	}
	
	private ReviewDto mapToDto(Review review) {
		ReviewDto reviewDto = new ReviewDto();
		reviewDto.setId(review.getId());
		reviewDto.setTitle(review.getTitle());
		reviewDto.setContent(review.getContent());
		reviewDto.setStars(review.getStars());
		return reviewDto;
	}
	
	private Review mapToEntity(ReviewDto reviewDto) {
		Review review = new Review();
		review.setTitle(reviewDto.getTitle());
		review.setContent(reviewDto.getContent());
		review.setStars(reviewDto.getStars());
		return review;
	}

	@Override
	public List<ReviewDto> getReviewByAthleteId(int id) {
		List<Review> reviews = reviewRepository.findByAthleteId(id);
		
		return reviews.stream().map(review -> mapToDto(review)).collect(Collectors.toList());
	}

	@Override
	public ReviewDto getReviewById(int reviewId, int athleteId) {
		
		Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(() -> new AthleteNotFoundException("Athlete with associated review not found"));
		Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review with associated pokemon not found"));
		
		// use a wrapper for equals() method instead of !=
		if(review.getAthlete().getId() != athlete.getId()) { 
			
			throw new ReviewNotFoundException("this review does not belong to a athlete");
		}
		
		return mapToDto(review);
	}

	@Override
	public ReviewDto updateReview(int athleteId, int reviewId, ReviewDto reviewDto) {
		Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(() -> new AthleteNotFoundException("Athlete with associated review not found"));
		Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review with associated pokemon not found"));
		
		// use a wrapper for equals() method instead of !=
		if(review.getAthlete().getId() != athlete.getId()) { 
			
			throw new ReviewNotFoundException("this review does not belong to a athlete");
		}
		
		review.setTitle(reviewDto.getTitle());
		review.setContent(reviewDto.getContent());
		review.setStars(reviewDto.getStars());
		
		Review updateReview = reviewRepository.save(review);
		
		return mapToDto(updateReview);
	}

	@Override
	public void deleteReview(int athleteId, int reviewId) {
		Athlete athlete = athleteRepository.findById(athleteId).orElseThrow(() -> new AthleteNotFoundException("Athlete with associated review not found"));
		Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new ReviewNotFoundException("Review with associated pokemon not found"));
		
		// use a wrapper for equals() method instead of !=
		if(review.getAthlete().getId() != athlete.getId()) { 
			
			throw new ReviewNotFoundException("this review does not belong to a athlete");
		}
		
		reviewRepository.delete(review);
		
	}

}
