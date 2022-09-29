package com.regulus.airlineservice.repositories;

import com.regulus.airlineservice.models.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {

    @Query("select a.airline_id from Airline a where a.airline_name=:name and a.iata=:iata")
    Integer findByAirline_nameAndIata(String name, String iata);
}
