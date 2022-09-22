package com.microservices.airportservices.repository;


import com.microservices.airportservices.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AirportRepo extends JpaRepository<Airport, Long>{

    Airport findByIdGeo(String idGeo);

    @Override
    Optional<Airport> findById(Long idAirport);

    @Query("select a.airport_id from Airport a where a.airportName=:airportName")
    String getByIdAirport(String airportName);
}
