package com.athletereview.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.athletereview.api.service.AthleteService;

@RestController
@RequestMapping("/api/")
public class AthleteController {
	
	private AthleteService athleteService;
	
	@Autowired
	public AthleteController(AthleteService athleteService) {
		this.athleteService = athleteService;
	}

	@GetMapping("athlete")
	public ResponseEntity<AthleteResponseDto> getAthletes(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
														  @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
		return new ResponseEntity<>(athleteService.getAllAthlete(pageNo, pageSize), HttpStatus.OK);
	}
	
	@GetMapping("athlete/names")
	public ResponseEntity<AthleteResponseDto> getAthletesByName(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
														  @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
														  @RequestParam String name) {
		return new ResponseEntity<>(athleteService.getAllAthleteByName(pageNo, pageSize, name), HttpStatus.OK);	
	}
	
	@GetMapping("athlete/types")
	public List<String> getListOfAthleteTypes() {
		return athleteService.getAllTypes();
	}
	
	@GetMapping("athlete/{id}")
	public ResponseEntity<AthleteDto> athleteDetail(@PathVariable int id) {
		return ResponseEntity.ok(athleteService.getAthleteById(id));
	}
	
	@PostMapping("athlete/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<AthleteDto> createAthlete(@RequestBody AthleteDto athleteDto) {
		return new ResponseEntity<>(athleteService.createAthlete(athleteDto), HttpStatus.CREATED);
	}
	
	@PutMapping("athlete/{id}/update")
	public  ResponseEntity<AthleteDto> updateAthlete(@PathVariable("id") int pokemonId, @RequestBody AthleteDto athlete ) {
		return new ResponseEntity<>( athleteService.updateAthlete(athlete, pokemonId), HttpStatus.OK );
	}
	
	@DeleteMapping("athlete/{id}/delete")
	public ResponseEntity<String> deleteAthlete(@PathVariable("id") int pokemonId) {
		athleteService.deleteAthlete(pokemonId);
		return new ResponseEntity<>("Pokemon deleted", HttpStatus.OK);
	}
	
}
