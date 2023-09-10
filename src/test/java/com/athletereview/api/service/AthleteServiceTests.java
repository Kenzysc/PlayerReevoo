package com.athletereview.api.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.athletereview.api.dto.AthleteDto;
import com.athletereview.api.dto.AthleteResponseDto;
import com.athletereview.api.models.Athlete;
import com.athletereview.api.repository.AthleteRepository;
import com.athletereview.api.service.impl.AthleteServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AthleteServiceTests {
	
	@Mock
	private AthleteRepository athleteRepository;
	
	@InjectMocks 
	private AthleteServiceImpl athleteService;
	
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
		when(athleteRepository.save(Mockito.any(Athlete.class))).thenReturn(athlete);
		
		AthleteDto savedAthlete = athleteService.createAthlete(athleteDto);
		
		Assertions.assertThat(savedAthlete).isNotNull();
	}
	
	@Test
	public void AthleteService_GetAllAthletes_ReturnsAthleteResponseDto() {
		Page<Athlete> athletes = Mockito.mock(Page.class);
		
		when(athleteRepository.findAll(Mockito.any(Pageable.class))).thenReturn(athletes);
		
		AthleteResponseDto savedAthlete = athleteService.getAllAthlete(1, 10);
		
		Assertions.assertThat(savedAthlete).isNotNull();
	}
	
	@Test
	public void AthleteService_GetAllAthletesByName_ReturnsAthleteResponseDto() {
		List<Athlete> athletes = Mockito.mock(List.class);
		
		when(athleteRepository.findAllByName(Mockito.any(String.class))).thenReturn(athletes);
		
		AthleteResponseDto savedAthlete = athleteService.getAllAthlete(1, 10);
		
		Assertions.assertThat(savedAthlete).isNotNull();
	}
	
//	@Test
//	public void AthleteService_GetAllTypes_ReturnsAthleteResponseDto() {
//		List<String> types = Mockito.mock(List.class);
//		
//		when(athleteRepository.findAllTypes()).thenReturn(types);
//		
//		List<String> listOfTypes = athleteService.getAllTypes();
//		
//		Assertions.assertThat(listOfTypes).isNotNull();
//	}
	
	@Test
	public void AthleteService_GetAthleteById_ReturnsAthleteDto() {
		when(athleteRepository.findById(1)).thenReturn(Optional.ofNullable(athlete));
		
		
		AthleteDto savedAthlete = athleteService.getAthleteById(1);
		
		Assertions.assertThat(savedAthlete).isNotNull();
	}
	
	@Test
	public void AthleteService_UpdateAthlete_ReturnsAthleteDto() {
		
		when(athleteRepository.findById(1)).thenReturn(Optional.ofNullable(athlete));
		when(athleteRepository.save(Mockito.any(Athlete.class))).thenReturn(athlete);
		
		AthleteDto savedAthlete = athleteService.updateAthlete(athleteDto, 1);
		
		Assertions.assertThat(savedAthlete).isNotNull();
	}
	
	@Test
	public void AthleteService_DeleteAthlete_ReturnsVoid() {
		when(athleteRepository.findById(1)).thenReturn(Optional.ofNullable(athlete));
		
		assertAll(() -> athleteService.deleteAthlete(1));
	}

}



