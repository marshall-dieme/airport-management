package com.microservices.airportgeoservices.repository;

import com.microservices.airportgeoservices.entity.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportGeoRepo extends JpaRepository<AirportGeo, Long> {

    @Override
    Optional<AirportGeo> findById(Long aLong);
}
