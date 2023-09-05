package com.athletereview.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.athletereview.api.dto.AthleteDto;
import com.athletereview.api.dto.AthleteResponseDto;

@RestController
@RequestMapping("/api/")
public class AthleteController {
	
	@GetMapping("athlete")
	public ResponseEntity<AthleteResponseDto> getAthletes(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
														  @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
		return null;
	}
	
	@GetMapping("athlete/name")
	public ResponseEntity<AthleteResponseDto> getAthletesByName(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
														  @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
		return null;
	}
	
	@GetMapping("athlete/type")
	public ResponseEntity<AthleteResponseDto> getAthletesByType(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
														  @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
		return null;
	}
	
	@GetMapping("athlete/{id}")
	public ResponseEntity<AthleteDto> athleteDetail(@PathVariable int id) {
		return null;
	}
	
	@PostMapping("athlete/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<AthleteDto> createAthlete(@RequestBody AthleteDto athleteDto) {
		return null;
	}
	
	@PutMapping("athlete/{id}/update")
	public  ResponseEntity<AthleteDto> updateAthlete(@PathVariable("id") int pokemonId, @RequestBody AthleteDto athlete ) {
		return null;
	}
	
	@DeleteMapping("athlete/{id}/delete")
	public ResponseEntity<String> deleteAthlete(@PathVariable("id") int pokemonId) {
		return null;
	}
	
}
