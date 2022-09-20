package com.microservices.airplane.Airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.airplane.Airport.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String>{

	
	//Airport findByAirportName(String airport_name);
	
	
	
}
