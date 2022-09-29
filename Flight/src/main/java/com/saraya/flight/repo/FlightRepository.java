package com.saraya.flight.repo;

import com.saraya.flight.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    Flight findById(long flight_id);
}
