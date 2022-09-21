package com.saraya.airlineservice.repository;

import com.saraya.airlineservice.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline , Integer> {
    Airline findByAirlineName(String airlineName);
}
