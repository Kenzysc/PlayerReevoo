package com.athletereview.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athletereview.api.models.Athlete;


public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
	
}
