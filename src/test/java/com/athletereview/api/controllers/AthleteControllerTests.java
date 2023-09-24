package com.athletereview.api.controllers;

import static org.mockito.BDDMockito.given;
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
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.athletereview.api.dto.AthleteDto;
import com.athletereview.api.dto.AthleteResponseDto;
import com.athletereview.api.models.Athlete;
import com.athletereview.api.service.AthleteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = AthleteController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class) 
public class AthleteControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AthleteService athleteService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private AthleteDto athleteDto;
	private int athleteId;
	private AthleteResponseDto responseDto;
	
	
	@BeforeEach
	public void init() {
		
		athleteDto = AthleteDto.builder().name("Messi").type("Football/Soccer").build();
		
		responseDto = AthleteResponseDto.builder().pageNo(1).pageSize(10)
				.last(true).content(Arrays.asList(athleteDto)).build();
		
		athleteId = 1;
	}
	
	@Test
	public void AthleteController_CreateAthlete_ReturnsCreated() throws Exception {
		given(athleteService.createAthlete(ArgumentMatchers.any())).willAnswer((
				Invocation -> Invocation.getArgument(0)));
		
		ResultActions response = mockMvc.perform(post("/api/athlete/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(athleteDto)));
		
		response.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.jsonPath("$.name",
					CoreMatchers.is(athleteDto.getName())))
			.andExpect(MockMvcResultMatchers.jsonPath("$.type",
					CoreMatchers.is(athleteDto.getType())));
	}
	
	@Test
	public void AthleteController_GetAllAthletes_ReturnsResponseDto() throws Exception {
		
		when(athleteService.getAllAthlete(1, 10)).thenReturn(responseDto);
		
		ResultActions response = mockMvc.perform(get("/api/athlete")
				.contentType(MediaType.APPLICATION_JSON)
				.param("pageNo", "1")
				.param("pageSize", "10"));
		
		response.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.content.size()",
				CoreMatchers.is(responseDto.getContent().size())));
		
	}
	
	@Test
	public void AthleteController_AthleteDetail_ReturnsAthleteDto() throws Exception {
		when(athleteService.getAthleteById(athleteId)).thenReturn(athleteDto);
		
		ResultActions response = mockMvc.perform(get("/api/athlete/" + athleteId) 
				.contentType(MediaType.APPLICATION_JSON));
		
		response.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.name", 
					CoreMatchers.is(athleteDto.getName())))
			.andExpect(MockMvcResultMatchers.jsonPath("$.type", 
					CoreMatchers.is(athleteDto.getType())));
				
	}
	
	@Test
	public void AthleteController_AthleteUpdate_ReturnsAthleteDto() throws Exception {
		when(athleteService.updateAthlete(athleteDto, athleteId)).thenReturn(athleteDto);
		
		ResultActions response = mockMvc.perform(put("/api/athlete/" + athleteId + "/update") 
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(athleteDto)));
		
		response.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.name", 
					CoreMatchers.is(athleteDto.getName())))
			.andExpect(MockMvcResultMatchers.jsonPath("$.type", 
					CoreMatchers.is(athleteDto.getType())));
	}
	
	@Test
	public void AthleteController_AtheleteDelete_ReturnsString() throws Exception {
		doNothing().when(athleteService).deleteAthlete(athleteId);
		
		ResultActions response = mockMvc.perform(delete("/api/athlete/" + athleteId + "/delete") 
				.contentType(MediaType.APPLICATION_JSON));
		
		response.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void AthleteController_AthleteSearch_ReturnsResponseDto() throws Exception {
		
		when(athleteService.searchAthlete(1, 10, "messi")).thenReturn(responseDto);
		
		ResultActions response = mockMvc.perform(get("/api/athlete/search")
				.contentType(MediaType.APPLICATION_JSON)
				.param("pageNo", "1")
				.param("pageSize", "10")
				.param("query", "messi"));
		
		response.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.content.size()",
				CoreMatchers.is(responseDto.getContent().size())));
		
	}
	
}
