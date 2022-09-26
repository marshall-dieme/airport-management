package com.saraya.airline.repo;

import com.saraya.airline.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Repository
public interface AirlineRepo  extends JpaRepository<Airline,Long> {

    @Query("select air.airline_id from Airline air where air.airlineName=:airlineName")
    Long getIdAirline(String airlineName);

    List<Airline> findByAirportId(Long idAirport);
}
