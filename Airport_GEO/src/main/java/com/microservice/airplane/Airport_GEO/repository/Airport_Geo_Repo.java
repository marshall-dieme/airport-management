package com.microservice.airplane.Airport_GEO.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservice.airplane.Airport_GEO.Enitity.Airport_Geo;


@Repository
public interface Airport_Geo_Repo extends JpaRepository<Airport_Geo, Long> {
	
	
	@Override
    Optional<Airport_Geo> findById(Long idGeo);

    @Query("select a.aiport_geo_id from Airport_Geo a where a.country=:country and a.city=:city")
    
    String getById(String country, String city);

}
