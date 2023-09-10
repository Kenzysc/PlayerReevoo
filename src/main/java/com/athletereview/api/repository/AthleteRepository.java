package com.athletereview.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athletereview.api.models.Athlete;


public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
	List<Athlete> findAllByName(String name);
	
	List<Athlete> findAllByType(String type);	
	
}
