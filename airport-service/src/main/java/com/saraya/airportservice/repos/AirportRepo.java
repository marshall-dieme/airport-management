package com.saraya.airportservice.repos;

import com.saraya.airportservice.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Long> {
    // Airport findByAirportName(String airport_name);
}
