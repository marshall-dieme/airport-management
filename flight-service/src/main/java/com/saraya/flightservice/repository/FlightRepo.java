package com.saraya.flightservice.repository;

import com.saraya.flightservice.bean.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {
    Flight findByFlightNo(String flightNo);
}
