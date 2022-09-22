package com.saraya.airlineservice.repos;

import com.saraya.airlineservice.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirlineRepo extends JpaRepository<Airline, Long> {
    @Query("select a.airline_id from Airline a where a.airline_name=:airline_name")
    Long getIdAirline(String airline_name);

    List<Airline> findByIdAirport(Long idAirport);
}
