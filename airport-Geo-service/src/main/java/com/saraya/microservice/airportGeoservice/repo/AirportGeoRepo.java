package com.saraya.microservice.airportGeoservice.repo;

import com.saraya.microservice.airportGeoservice.model.AirportGeo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportGeoRepo extends JpaRepository<AirportGeo, Integer> {

    @Query("select g.airport_geo_id from AirportGeo g where g.country=:country and g.city=:city")
    Integer getIdAirportGeo(String country,String city);

//    AirportGeo findByCity(String city);

        // @Query(value = "select dept_id from departments where name=?1", nativeQuery = true)
       /* @Query("select d from airport_geo d where d.country=:country")
        AirportGeo getIdarp(String country);*/

      //  AirportGeo  findByCountry(String country);


}
