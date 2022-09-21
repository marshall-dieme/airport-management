package com.saraya.airportgeoservice.repo;

import com.saraya.airportgeoservice.bean.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportGeoRepo extends JpaRepository<AirportGeo, String> {
//    AirportGeo findByAirport_geo_id(String airport);
}
