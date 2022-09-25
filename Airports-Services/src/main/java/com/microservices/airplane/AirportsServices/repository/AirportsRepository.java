package com.microservices.airplane.AirportsServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.airplane.AirportsServices.entity.Airports;


@Repository
public interface AirportsRepository  extends JpaRepository<Airports, String>{
	
	Airports findByIdAirportGeo(String idAirportGeo);
	
	Airports findByAirportname(String airportname);
	
	

}
