package com.saraya.Flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.Flight.model.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer>{

	Flight findByFlightNo(String flightNo);

	Flight findByFlightId(int flightId);
}
