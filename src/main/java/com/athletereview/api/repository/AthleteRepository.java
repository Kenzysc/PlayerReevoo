package com.athletereview.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.athletereview.api.models.Athlete;


public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
	List<Athlete> findAllByName(String name);
	
	List<Athlete> findAllByType(String type);

	@Query("SELECT a from Athlete a WHERE a.name LIKE CONCAT('%', :query, '%')")
	Page<Athlete> searchAthlete(String query, Pageable pageable);	
	
}
