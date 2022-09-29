package com.saraya.airport.repo;

import com.saraya.airport.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Long getIdAirportiataandicaoandname(String iata, String icao, String name);

    void deleteByiataandicaoandname(String iata, String icao, String name);
}
