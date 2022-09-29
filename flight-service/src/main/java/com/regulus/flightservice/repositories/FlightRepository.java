package com.regulus.flightservice.repositories;

import com.regulus.flightservice.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query("select f.flight_id from Flight f where f.flight_no=:flightNo")
    Integer findByFlight_no(String flightNo);
}
