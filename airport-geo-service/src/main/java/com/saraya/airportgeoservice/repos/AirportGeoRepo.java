package com.saraya.airportgeoservice.repos;

import com.saraya.airportgeoservice.model.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportGeoRepo extends JpaRepository<AirportGeo,Long> {

    AirportGeo findByCityAndCountry (String city, String country);

    @Query("select a.airport_geo_id from AirportGeo a where a.city=:city and a.country=:country")
    Long getIdAirportGeo(String city,String country);


}
