package com.athletereview.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athletereview.api.dto.AthleteDto;
import com.athletereview.api.dto.AthleteResponseDto;
import com.athletereview.api.repository.AthleteRepository;
import com.athletereview.api.service.AthleteService;

@Service
public class AthleteServiceImpl implements AthleteService {
	
	private AthleteRepository athleteRepository;
	
	@Autowired
	public AthleteServiceImpl(AthleteRepository athleteRepository) {
		this.athleteRepository = athleteRepository;
	}

	@Override
	public AthleteDto createAthlete(AthleteDto athleteDto) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public AthleteResponseDto getAllAthlete(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public AthleteResponseDto getAllAthleteByName(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public AthleteResponseDto getAllAthleteByType(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AthleteDto getAthleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AthleteDto updateAthlete(AthleteDto athleteDto, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAthlete(int id) {
		// TODO Auto-generated method stub
		
	}

}
