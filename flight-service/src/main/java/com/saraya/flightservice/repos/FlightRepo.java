package com.saraya.flightservice.repos;

import com.saraya.flightservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

    @Query("select f.flightId from Flight f where f.flightNo=:flightNo")
    Long getFlightId(String flightNo);
}
