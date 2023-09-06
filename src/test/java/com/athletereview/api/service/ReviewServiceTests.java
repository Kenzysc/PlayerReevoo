package com.athletereview.api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.athletereview.api.dto.AthleteDto;
import com.athletereview.api.dto.ReviewDto;
import com.athletereview.api.models.Athlete;
import com.athletereview.api.models.Review;
import com.athletereview.api.repository.AthleteRepository;
import com.athletereview.api.repository.ReviewRepository;
import com.athletereview.api.service.impl.AthleteServiceImpl;
import com.athletereview.api.service.impl.ReviewServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceTests {
	
	@Mock
	private ReviewRepository reviewRepository;
	
	@Mock 
	private AthleteServiceImpl athleteService;
	
	@InjectMocks
	private ReviewServiceImpl reviewService;
	
	private Athlete athlete;
	private Review review;
	private ReviewDto reviewDto;
	private int reviewId;
	private int athleteId;
	
	@BeforeEach
	public void init() {
		athlete = Athlete.builder().name("Messi").type("Football/Soccer").build();
		
		review = Review.builder().title("Dribble God").content("He dribbles like its magic").stars(5).build();
		
		reviewDto = ReviewDto.builder().title("Dribble God").content("He dribbles like its magic").stars(5).build();
		
		reviewId = 1;
		
		athleteId = 1;
		
	}
	
	@Test
	public void ReviewService_CreateReview_ReturnsReviewDto() {
		
	}
	
	@Test
	public void ReviewService_FindByAthleteId_ReturnsReviewDtoList() {
		
	}
	
	@Test
	public void ReviewService_FindById_ReturnsReviewDto() {
		
	}
	
	@Test
	public void ReviewService_UpdateReview_ReturnsReviewDto() {
		
	}
	
	@Test
	public void ReviewService_DeleteReview_ReturnsVoid() {
		
	}

}









