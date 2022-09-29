package com.saraya.airportgeoservice.repository;

import com.saraya.airportgeoservice.model.Airport_Geo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Airport_GeoRepository extends JpaRepository<Airport_Geo, Long> {

    //@Query(value = "select dept_id from departments where name=?1", nativeQuery = true)
    @Query("select a.airport_geo_id from Airport_Geo a where a.country=:country and a.city=:city")
    Long getIdAirport_Geo(String country, String city);

    //Long findAirport_GeoByCountryAndCity(String country, String city);




}
