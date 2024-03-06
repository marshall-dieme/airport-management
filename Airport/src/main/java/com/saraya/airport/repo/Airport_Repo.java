package com.saraya.airport.repo;

import com.saraya.airport.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Airport_Repo extends JpaRepository<Airport,Long> {
@Query("SELECT a.airport_id from Airport a where a.airport_name=:airport_name")

    Long getIdAirport(String   airport_name);

    Airport findByIdAirportGeo(Long idAirportGeo);
}
