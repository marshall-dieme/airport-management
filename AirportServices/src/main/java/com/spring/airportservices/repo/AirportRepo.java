package com.spring.airportservices.repo;


import com.spring.airportservices.bean.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepo extends JpaRepository<Airport,Integer> {
    List<Airport> findByAirportGeoId(String airportGeoId);

    Airport findByAirportName(String airportName);

}
