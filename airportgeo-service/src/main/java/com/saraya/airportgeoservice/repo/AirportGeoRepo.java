package com.saraya.airportgeoservice.repo;

import com.saraya.airportgeoservice.bean.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportGeoRepo extends JpaRepository<AirportGeo, Integer> {
    Optional<AirportGeo> findByCountryAndCity(String country, String city);
}
