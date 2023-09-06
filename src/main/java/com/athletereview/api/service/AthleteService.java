package com.athletereview.api.service;

import java.util.List;

import com.athletereview.api.dto.AthleteDto;
import com.athletereview.api.dto.AthleteResponseDto;

public interface AthleteService {
	
	AthleteDto createAthlete(AthleteDto athleteDto);
	
	AthleteResponseDto getAllAthlete(int pageNo, int pageSize);
	
	AthleteDto getAthleteById(int id);
	
	AthleteResponseDto getAllAthleteByName(int pageNo, int pageSize, String name);
	
	List<String> getAllTypes();
	
	AthleteDto updateAthlete(AthleteDto athleteDto, int id);
	
	void deleteAthlete(int id);
	
	
	
}