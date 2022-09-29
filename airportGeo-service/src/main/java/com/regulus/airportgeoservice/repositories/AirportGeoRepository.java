package com.regulus.airportgeoservice.repositories;

import com.regulus.airportgeoservice.models.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportGeoRepository extends JpaRepository<AirportGeo, Integer> {

    @Query("select a.airport_geo_id from AirportGeo a where a.city=:city and a.country=:country")
    Integer findByCityAndCountry(String city, String country);

}
