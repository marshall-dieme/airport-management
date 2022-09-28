package com.saraya.flightservice.repo;

import com.saraya.flightservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
}
