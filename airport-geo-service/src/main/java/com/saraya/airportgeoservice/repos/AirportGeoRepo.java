package com.saraya.airportgeoservice.repos;

import com.saraya.airportgeoservice.model.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportGeoRepo extends JpaRepository<AirportGeo,Long> {

    AirportGeo findByCityAndCountry (String city, String country);


}
