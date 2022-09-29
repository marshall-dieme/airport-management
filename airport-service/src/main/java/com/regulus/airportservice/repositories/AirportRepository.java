package com.regulus.airportservice.repositories;


import com.regulus.airportservice.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {

    @Query("select a.airport_id from Airport a where a.airport_name=:name")
    Integer findByAirport_name(String name);
}
