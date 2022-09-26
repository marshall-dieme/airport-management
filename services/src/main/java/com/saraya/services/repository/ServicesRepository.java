package com.saraya.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.services.model.Services;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
	
	List<Services> findByAirportId(Long airportId);
}
