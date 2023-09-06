package com.athletereview.api.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.athletereview.api.dto.ReviewDto;
import com.athletereview.api.models.Athlete;
import com.athletereview.api.models.Review;
import com.athletereview.api.repository.AthleteRepository;
import com.athletereview.api.repository.ReviewRepository;
import com.athletereview.api.service.impl.ReviewServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceTests {
	
	@Mock
	private ReviewRepository reviewRepository;
	
	@Mock 
	private AthleteRepository athleteRepository;
	
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

		when(athleteRepository.findById(athlete.getId())).thenReturn(Optional.of(athlete)); 
		
		when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(review);		
		
		ReviewDto savedReview = reviewService.createReview(athlete.getId(), reviewDto);
		
		Assertions.assertThat(savedReview).isNotNull();
	}
	
	@Test
	public void ReviewService_FindByAthleteId_ReturnsReviewDtoList() {
		
		when(reviewRepository.findByAthleteId(reviewId)).thenReturn(Arrays.asList(review));
		
		List<ReviewDto> athleteReturn = reviewService.getReviewByAthleteId(reviewId);
		
		Assertions.assertThat(athleteReturn).isNotNull();
	}
	
	@Test
	public void ReviewService_FindById_ReturnsReviewDto() {
		review.setAthlete(athlete);
		
		when(athleteRepository.findById(athleteId)).thenReturn(Optional.of(athlete));
		when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));
		
		ReviewDto reviewReturn = reviewService.getReviewById(reviewId, athleteId);
		
		Assertions.assertThat(reviewReturn).isNotNull();
	}
	
	@Test
	public void ReviewService_UpdateReview_ReturnsReviewDto() {
		athlete.setReviews(Arrays.asList(review));;
		review.setAthlete(athlete);
		
		when(athleteRepository.findById(athleteId)).thenReturn(Optional.of(athlete));
		when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));
		
		when(reviewRepository.save(review)).thenReturn(review);
		
		ReviewDto updateReview = reviewService.updateReview(athleteId, reviewId, reviewDto);
		
		Assertions.assertThat(updateReview).isNotNull();
	}
	
	@Test
	public void ReviewService_DeleteReview_ReturnsVoid() {
		athlete.setReviews(Arrays.asList(review));
		review.setAthlete(athlete);
		
		when(athleteRepository.findById(athleteId)).thenReturn(Optional.of(athlete));
		when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));
		
		assertAll(() -> reviewService.deleteReview(athleteId, reviewId));
	}

}









