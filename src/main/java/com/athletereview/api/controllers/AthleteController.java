package com.athletereview.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.athletereview.api.dto.AthleteDto;
import com.athletereview.api.dto.AthleteResponseDto;

@RestController
@RequestMapping("/api/")
public class AthleteController {
	
	@GetMapping("athlete")
	public ResponseEntity<AthleteResponseDto> getAthletes() {
		return null;
	}
	
	@GetMapping("athlete/{id}")
	public ResponseEntity<AthleteDto> athleteDetail() {
		return null;
	}
	
	@PostMapping("athlete/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<AthleteDto> createAthlete() {
		return null;
	}
	
	@PutMapping("athlete/{id}/update")
	public  ResponseEntity<AthleteDto> updateAthlete() {
		return null;
	}
	
	@DeleteMapping("athlete/{id}/delete")
	public ResponseEntity<String> deleteAthlete() {
		return null;
	}
	
}
