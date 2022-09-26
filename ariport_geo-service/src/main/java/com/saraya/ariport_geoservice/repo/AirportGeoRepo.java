package com.saraya.ariport_geoservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saraya.ariport_geoservice.model.AirportGeo;

@Repository
public interface AirportGeoRepo extends JpaRepository<AirportGeo, Long>{
	
	@Query("select a.airportGeoId from AirportGeo a where a.country=:country and a.city=:city")
    Long getAirportGeoId(String country, String city);
	
	AirportGeo findByCountryAndCity(String country, String city);
}
