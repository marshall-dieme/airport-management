package com.saraya.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saraya.airport.model.Airport;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Long>{

	@Query("select a.airportId from Airport a where a.airportName=:airportName")
	Long getByName(String airportName);
	
	Airport findByAirportGeoId(Long airportGeoId);
}
