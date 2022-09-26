package com.saraya.airportservice.repo;

import com.saraya.airportservice.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Long> {

    Airport findByCountryAndCity(String iata, String icao, String airport_name);
}
