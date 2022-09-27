package com.saraya.Airportservice.repository;

import com.saraya.Airportservice.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    @Query("select a from Airport a where a.airport_id = ?1")
    Airport findByAirport_id(Long airport_id);
}
