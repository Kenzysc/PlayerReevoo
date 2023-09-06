package com.athletereview.api.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.athletereview.api.dto.ReviewDto;
import com.athletereview.api.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ReviewController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ReviewControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ReviewService reviewService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private ReviewDto reviewDto;
	private int reviewId;
	private int athleteId;
	
	@BeforeEach
	public void init() {
		reviewDto = ReviewDto.builder().title("Dribble God").content("He dribbles like its magic").stars(5).build();
		
		reviewId = 1;
		athleteId = 1;
	}
	
	@Test
	public void ReviewController_GetReviewsByAthleteId_ReturnsReviewDtoList() throws Exception {
		when(reviewService.getReviewByAthleteId(athleteId))
		.thenReturn(Arrays.asList(reviewDto));
	
		ResultActions response = mockMvc
			.perform(get("/api/athlete/" + athleteId + "/reviews")
			.contentType(MediaType.APPLICATION_JSON));
	
		response.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.size()", 
				CoreMatchers.is(Arrays.asList(reviewDto).size())));
	}
	
	@Test
	public void ReviewController_ReviewUpdate_ReturnsReviewDto() throws Exception {
		when(reviewService.updateReview(athleteId, reviewId, reviewDto)).thenReturn(reviewDto);
		
		ResultActions response = mockMvc.perform(put("/api/athlete/" + athleteId + "/" + reviewId)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(reviewDto)));
		
		response.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.title", 
					CoreMatchers.is(reviewDto.getTitle())))
			.andExpect(MockMvcResultMatchers.jsonPath("$.content", 
					CoreMatchers.is(reviewDto.getContent())))
			.andExpect(MockMvcResultMatchers.jsonPath("$.stars", 
					CoreMatchers.is(reviewDto.getStars())));
	}
	
	@Test
	public void ReviewController_CreateReview_ReturnsReviewDto() throws Exception {
		when(reviewService.createReview(athleteId, reviewDto)).thenReturn(reviewDto);

		ResultActions response = mockMvc.perform(post("/api/athlete/" + athleteId + "/review" )
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(reviewDto)));

		
		response.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.jsonPath("$.title", 
					CoreMatchers.is(reviewDto.getTitle())))
			.andExpect(MockMvcResultMatchers.jsonPath("$.content", 
					CoreMatchers.is(reviewDto.getContent())))
			.andExpect(MockMvcResultMatchers.jsonPath("$.stars", 
					CoreMatchers.is(reviewDto.getStars())));
	}
	
	@Test
	public void ReviewController_GetReviewsById_ReturnsReviewDto() throws Exception {
		when(reviewService.getReviewById(reviewId, athleteId))
		.thenReturn(reviewDto);
	
		ResultActions response = mockMvc
				.perform(get("/api/athlete/" + athleteId + "/" + reviewId)
				.contentType(MediaType.APPLICATION_JSON));
		
		response.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.title", 
					CoreMatchers.is(reviewDto.getTitle())))
			.andExpect(MockMvcResultMatchers.jsonPath("$.content", 
					CoreMatchers.is(reviewDto.getContent())))
			.andExpect(MockMvcResultMatchers.jsonPath("$.stars", 
					CoreMatchers.is(reviewDto.getStars())));
	}
	
	@Test
	public void ReviewController_ReviewDelete_RetrunsString() throws Exception {
		doNothing().when(reviewService).deleteReview(athleteId, reviewId);
		
		ResultActions response = mockMvc.perform(delete("/api/athlete/" + athleteId + "/reviews/" + reviewId)
				.contentType(MediaType.APPLICATION_JSON)); 
		
		response.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}




