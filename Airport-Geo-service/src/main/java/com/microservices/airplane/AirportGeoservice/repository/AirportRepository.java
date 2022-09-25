package com.microservices.airplane.AirportGeoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.airplane.AirportGeoservice.entity.AirportGeo;

@Repository
public interface AirportRepository extends JpaRepository<AirportGeo, String>{
	
	AirportGeo findByCountryAndCity(String country, String city);
	

}
