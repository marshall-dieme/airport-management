package com.saraya.flightservice.repository;

import com.saraya.flightservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight , Integer> {
    Flight findByFlightNo(String flightNo);
}
