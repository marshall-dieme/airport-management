package com.microservices.airlineairportservices.repository;

import com.microservices.airlineairportservices.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AirlineRepo extends JpaRepository<Airline,Long > {

    List<Airline> findByIdAirport(String idAirport);

    @Override
    Optional<Airline> findById(Long idAirline);

    @Query("select ai.airline_id from Airline ai where ai.airlineName=:airlineName")
    String getByIdAirline(String airlineName);

}
