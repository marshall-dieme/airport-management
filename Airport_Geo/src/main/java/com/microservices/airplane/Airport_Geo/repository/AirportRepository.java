package com.microservices.airplane.Airport_Geo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.airplane.Airport_Geo.entity.AirportGeo;

@Repository
public interface AirportRepository extends JpaRepository<AirportGeo, String> {
	
	
	
	
	AirportGeo findByCountry(String country);

}
