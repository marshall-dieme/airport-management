package com.saraya.airport_geoservices.repository;

import com.saraya.airport_geoservices.model.Airport_geo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Airport_geoRepo extends JpaRepository<Airport_geo, Long> {
    @Query("select a.airport_geo_id from Airport_geo a where a.country =:country and a.city =:city")
    Airport_geo findAirport_geoByCountryAndCity(String country,String city);
}
