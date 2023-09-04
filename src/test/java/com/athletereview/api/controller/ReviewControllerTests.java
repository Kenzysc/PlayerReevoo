package com.athletereview.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.athletereview.api.controllers.ReviewController;
import com.athletereview.api.dto.ReviewDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ReviewController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ReviewControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private ReviewDto reviewDto;
	private int reviewId;
	private int athleteId;
	
	@BeforeEach
	private void init() {
		reviewDto = ReviewDto.builder().title("Dribble God").content("He dribbles like its magic").stars(5).build();
		
		reviewId = 1;
		athleteId = 1;
	}
	
	@Test
	private void ReviewController_GetReviewsByAthleteId_ReturnsReviewDtoList() throws Exception {
		
	}
	
	@Test
	private void ReviewController_ReviewUpdate_ReturnsReviewDto() throws Exception {
		
	}
	
	@Test
	private void ReviewController_CreateReview_ReturnsReviewDto() throws Exception {
		
	}
	
	@Test
	private void ReviewController_GetReviewsById_ReturnsReviewDto() throws Exception {
		
	}
	
	@Test
	private void ReviewController_ReviewDelete_RetrunsString() throws Exception {
		
	}
	
}




