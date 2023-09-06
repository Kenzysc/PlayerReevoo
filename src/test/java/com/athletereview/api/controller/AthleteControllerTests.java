package com.athletereview.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.athletereview.api.controllers.AthleteController;
import com.athletereview.api.dto.AthleteDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = AthleteController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class) 
public class AthleteControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private AthleteDto athleteDto;
	private int athleteId;
	
	@BeforeEach
	public void init() {
		athleteDto = AthleteDto.builder().name("Messi").type("Football/Soccer").build();
		
		athleteId = 1;
	}
	
	@Test
	public void AthleteController_CreatePokemon_ReturnsCreated() throws Exception {
		
	}
	
	@Test
	public void AthleteController_GetAllAthletes_ReturnsResponseDto() throws Exception {
		
	}
	
	@Test
	public void AthleteController_GetAllAthletesByName_ReturnsResponseDto() throws Exception {
		
	}
	
	@Test
	public void AthleteController_GetListAthletesType_ReturnsResponseDto() throws Exception {
		
	}
	
	
	@Test
	public void AthleteController_AthleteDetail_ReturnsAthleteDto() throws Exception {
		
	}
	
	@Test
	public void AthleteController_AthleteUpdate_ReturnsAthleteDto() throws Exception {
		
	}
	
	@Test
	public void AthleteController_AtheleteDelete_ReturnsString() throws Exception {
		
	}
	
}
