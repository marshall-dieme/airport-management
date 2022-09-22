package com.saraya.airline.repository;

import com.saraya.airline.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long>{

    @Query("select a.airline_id from Airline a where a.airline_name=:airline_name and a.iata=:iata")
    Long getIdAirline(String airline_name, String iata);

}
