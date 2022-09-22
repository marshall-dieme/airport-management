package com.saraya.airportservice.repository;

import com.saraya.airportservice.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport , Integer> {
    Airport findByIata(String iata);

    Airport findByAirportName(String airportName);
}
