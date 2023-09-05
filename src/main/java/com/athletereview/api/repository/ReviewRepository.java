package com.athletereview.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athletereview.api.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findByAthleteId(int athleteId);
}
