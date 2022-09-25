package com.spring.airportgeoservices.repo;


import com.spring.airportgeoservices.bean.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportGeoRepo extends JpaRepository<AirportGeo, String> {
AirportGeo findByAirportGeoId(String id);

@Query("select d.airportGeoId from AirportGeo d where d.city=:city and d.country=:country")
String getAirportGeoId(String city, String country);

AirportGeo findByCityAndCountry(String city, String country);

}
