package com.regulus.flightservice.repositories;

import com.regulus.flightservice.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query("select a.flight_id from Flight a where a.flight_no=:flightNo")
    Integer findByFlight_no(String flightNo);
}
