package com.athletereview.api.service;

import com.athletereview.api.dto.AthleteDto;
import com.athletereview.api.dto.AthleteResponseDto;

public interface AthleteService {
	
	AthleteDto createAthlete(AthleteDto athleteDto);
	
	AthleteResponseDto getAllAthlete(int pageNo, int pageSize);
	
	AthleteDto getAthleteById(int id);
			
	AthleteDto updateAthlete(AthleteDto athleteDto, int id);
	
	void deleteAthlete(int id);
	
	AthleteResponseDto searchAthlete(int pageNo, int pageSize, String query);
	
	
	
}