package com.saraya.airportservice.repository;

import com.saraya.airportservice.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    @Query("select a.airport_id from Airport a where a.airport_name=:airport_name ")
    Long getIdAirport(String airport_name);
}
