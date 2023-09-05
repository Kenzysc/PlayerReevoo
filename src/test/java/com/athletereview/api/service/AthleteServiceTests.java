package com.athletereview.api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.athletereview.api.dto.AthleteDto;
import com.athletereview.api.models.Athlete;
import com.athletereview.api.repository.AthleteRepository;
import com.athletereview.api.service.impl.AthleteServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AthleteServiceTests {
	
	@Mock
	private AthleteRepository athleteRepository;
	
	@InjectMocks 
	private AthleteServiceImpl athleteServiceImpl;
	
	private Athlete athlete;
	private AthleteDto athleteDto;
	private int athleteId;
	
	@BeforeEach
	public void init() {
		athlete = Athlete.builder().name("Messi").type("Football/Soccer").build();
		
		athleteDto = AthleteDto.builder().name("Messi").type("Football/Soccer").build();
		
		athleteId = 1;
		
	}
	
	@Test
	public void AthleteService_CreateAthlete_ReturnsAthleteDto() {
		
	}
	
	@Test
	public void AthleteService_GetAllAthletes_ReturnsAthleteResponseDto() {
		
	}
	
	@Test
	public void AthleteService_GetAllAthletesByName_ReturnsAthleteResponseDto() {
		
	}
	
	@Test
	public void AthleteService_GetAllAthletesByType_ReturnsAthleteResponseDto() {
		
	}
	
	@Test
	public void AthleteService_GetAthleteById_ReturnsAthleteDto() {
		
	}
	
	@Test
	public void AthleteService_UpdateAthlete_ReturnsAthleteDto() {
		
	}
	
	@Test
	public void AthleteService_DeleteAthlete_ReturnsVoid() {
		
	}

}



