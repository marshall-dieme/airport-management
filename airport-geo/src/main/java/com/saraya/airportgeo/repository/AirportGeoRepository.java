package com.saraya.airportgeo.repository;

import com.saraya.airportgeo.model.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportGeoRepository extends JpaRepository<AirportGeo , Integer> {
    AirportGeo findByCountryAndCity(String country, String city);

    @Query("select c.airport_geo_id from AirportGeo c where c.country=:country")
    String getIdAirportGeo(String country);

}
