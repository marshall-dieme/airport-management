package com.microservices.airportgeoservices.repository;

import com.microservices.airportgeoservices.entity.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportGeoRepo extends JpaRepository<AirportGeo, Long> {

    @Override
    Optional<AirportGeo> findById(Long idGeo);

    @Query("select a.airport_geo_id from AirportGeo a where a.country=:country and a.city=:city")
    String getById(String country, String city);


}
