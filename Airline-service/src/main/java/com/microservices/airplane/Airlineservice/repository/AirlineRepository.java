package com.microservices.airplane.Airlineservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.airplane.Airlineservice.entity.Airline;



@Repository
public interface AirlineRepository extends JpaRepository<Airline, String >{

	List<Airline> findByIdAir(String idAir);
	
	Airline findByAirlinename(String airlinename);
	
	
	
	
}
