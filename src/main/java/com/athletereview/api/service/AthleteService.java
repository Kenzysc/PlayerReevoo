package com.athletereview.api.service;

import com.athletereview.api.dto.AthleteDto;
import com.athletereview.api.dto.AthleteResponseDto;

public interface AthleteService {
	
	AthleteDto createAthlete(AthleteDto athleteDto);
	
	AthleteResponseDto getAllAthlete(int pageNo, int pageSize);
	
	AthleteDto getAthleteById(int id);
	
	AthleteResponseDto getAllAthleteByName(int pageNo, int pageSize);
	
	AthleteResponseDto getAllAthleteByType(int pageNo, int pageSize);
	
	AthleteDto updateAthlete(AthleteDto athleteDto, int id);
	
	void deleteAthlete(int id);
	
	
	
}