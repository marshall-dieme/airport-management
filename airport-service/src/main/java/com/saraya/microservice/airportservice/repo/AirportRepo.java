package com.saraya.microservice.airportservice.repo;/* @Query("select d from airport_geo d where d.country=:country")
        AirportGeo getIdarp(String country);*/

import com.saraya.microservice.airportservice.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Integer> {
         @Query("select d.airport_id from Airport d where d.airport_name=:airport_name ")
        Integer  getIdarp(String airport_name);

         Airport getAirportsByIdGeo(Integer idGeo);







       //  @Query(value = "select dept_id from departments where name=?1", nativeQuery = true)
     // String getIdarp(String name);
        /*@Query("Select d from airport_data d where d.airport_name=?1")
        Airport  findByAirport_name(String airport_name);*/

        /*@Query("SELECT a FROM airport_data d WHERE d.airport_name=?1")
        Airport getAirportByName(String airport_name);*/
        /*@Query("SELECT u FROM airport_data u WHERE u.airport_name = ?1")
        Airport findAirportByAirport_name(String airport_name);*/


}
