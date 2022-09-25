package com.saraya.airportgeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.airportgeo.model.AirportGeo;
@Repository
public interface AirportGeoRepository extends JpaRepository<AirportGeo, Long>{
	AirportGeo findByCountryAndCity(String country, String City);
}
