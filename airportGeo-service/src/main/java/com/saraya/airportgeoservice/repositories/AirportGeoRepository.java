package com.saraya.airportgeoservice.repositories;

import com.saraya.airportgeoservice.models.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportGeoRepository extends JpaRepository<AirportGeo,Long> {
}
