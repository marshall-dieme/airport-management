package com.spring.airportgeoservice.repo;

import com.spring.airportgeoservice.bean.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportGeoRepo extends JpaRepository<AirportGeo, Integer> {
AirportGeo findByAirportGeoId(int id);

}
