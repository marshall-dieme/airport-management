package com.saraya.microservices.airportmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.microservices.airportmanagement.model.Airport_Geo;


@Repository
public interface AirGeoRepository extends JpaRepository<Airport_Geo, Long>{

	//Airport_Geo_DTO findByCity(String city);
	
	
	
	
//	Airport_Geo save(Airport_Geo_DTO dto);
//
//	static String getAirportName(String name) {
//		return null;
//	}
	
}
