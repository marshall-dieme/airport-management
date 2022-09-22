package com.saraya.airportservice.repos;

import com.saraya.airportservice.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Long> {
    // Airport findByAirportName(String airport_name);

    @Query("select a.id from Airport a where a.airport_name=:airport_name")
    Long getIdAirport(String airport_name);

   Airport findByIdAirportGeo(Long idAirportGeo);
}
