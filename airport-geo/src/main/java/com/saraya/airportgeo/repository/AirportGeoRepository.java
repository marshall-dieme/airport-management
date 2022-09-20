package com.saraya.airportgeo.repository;

import com.saraya.airportgeo.model.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportGeoRepository extends JpaRepository<AirportGeo , Integer> {
    AirportGeo findByCountryAndCity(String country, String city);
}
