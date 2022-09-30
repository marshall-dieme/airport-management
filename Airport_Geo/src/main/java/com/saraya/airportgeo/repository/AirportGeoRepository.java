package com.saraya.airportgeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saraya.airportgeo.model.AirportGeo;
@Repository
public interface AirportGeoRepository extends JpaRepository<AirportGeo, Long>{
	//AirportGeo findByCountryAndCity(String country, String City);
	@Query("select a.airport_geo_id from AirportGeo a where a.country=:country and city=:city")
	Long findByCountryAndCity(String country, String city);
}
