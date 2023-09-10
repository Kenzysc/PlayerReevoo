package com.athletereview.api.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.athletereview.api.dto.AthleteDto;
import com.athletereview.api.dto.AthleteResponseDto;
import com.athletereview.api.exceptions.AthleteNotFoundException;
import com.athletereview.api.models.Athlete;
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
		
		Athlete athlete = new Athlete();
		athlete.setName(athleteDto.getName());
		athlete.setType(athleteDto.getType());
		
		Athlete newAthlete = athleteRepository.save(athlete);
		
		AthleteDto athleteRespnse = new AthleteDto();
		athleteRespnse.setId(newAthlete.getId());
		athleteRespnse.setName(newAthlete.getName());
		athleteRespnse.setType(newAthlete.getType());
		
		return athleteRespnse;
	}

	@Override
	public AthleteResponseDto getAllAthlete(int pageNo, int pageSize) {
		
			Pageable pageable = PageRequest.of(pageNo, pageSize);
			
			Page<Athlete> athletes = athleteRepository.findAll(pageable);
			List<Athlete> listOfAthlete = athletes.getContent();
			
			List<AthleteDto> content = listOfAthlete.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
			
			AthleteResponseDto athleteResponse = new AthleteResponseDto();
			athleteResponse.setContent(content);
			athleteResponse.setPageNo(athletes.getNumber());
			athleteResponse.setPageSize(athletes.getSize());
			athleteResponse.setTotalElement(athletes.getTotalElements());
			athleteResponse.setTotalPages(athletes.getTotalPages());
			athleteResponse.setLast(athletes.isLast());
			
			return athleteResponse;
		
	}
	
	private AthleteDto mapToDto(Athlete athlete) {
		AthleteDto athleteDto = new AthleteDto();
		athleteDto.setId(athlete.getId());
		athleteDto.setName(athlete.getName());
		athleteDto.setType(athlete.getType());
		return athleteDto;
	}
	
	private Athlete mapToEntity(AthleteDto athleteDto) {
		Athlete athlete = new Athlete();
		athlete.setId(athleteDto.getId());
		athlete.setName(athleteDto.getName());
		athlete.setType(athleteDto.getType());
		return athlete;
	}
	
	@Override
	public AthleteResponseDto getAllAthleteByName(int pageNo, int pageSize, String name) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		List<Athlete> athletesList = athleteRepository.findAllByName(name);
		Page<Athlete> athletes = new PageImpl<Athlete>(athletesList, pageable, athletesList.size());
		List<Athlete> listOfAthlete = athletes.getContent();
		
		List<AthleteDto> content = listOfAthlete.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
		
		AthleteResponseDto athleteResponse = new AthleteResponseDto();
		athleteResponse.setContent(content);
		athleteResponse.setPageNo(athletes.getNumber());
		athleteResponse.setPageSize(athletes.getSize());
		athleteResponse.setTotalElement(athletes.getTotalElements());
		athleteResponse.setTotalPages(athletes.getTotalPages());
		athleteResponse.setLast(athletes.isLast());
		
		return athleteResponse;
	}
	
//	@Override
//	public List<String> getAllTypes() {
//		
//		List<String> types = athleteRepository.findAllTypes();
//		
//		return types;
//	}

	@Override
	public AthleteDto getAthleteById(int id) {
		Athlete athlete = athleteRepository.findById(id).orElseThrow(() -> new AthleteNotFoundException("Athlete could not be found"));
		return mapToDto(athlete);
	}

	@Override
	public AthleteDto updateAthlete(AthleteDto athleteDto, int id) {
		Athlete athlete = athleteRepository.findById(id).orElseThrow(() -> new AthleteNotFoundException("Athlete could not be updated"));
		
		athlete.setName(athleteDto.getName());
		athlete.setType(athleteDto.getType());
		
		
		Athlete updatedPokemon = athleteRepository.save(athlete); 
		
		return mapToDto(updatedPokemon);
	}

	@Override
	public void deleteAthlete(int id) {
		Athlete athlete = athleteRepository.findById(id).orElseThrow(() -> new AthleteNotFoundException("Athlete could not be found"));
		athleteRepository.delete(athlete);
		
	}

}
