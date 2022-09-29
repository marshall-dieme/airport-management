package com.saraya.airportgeo.repo;

import com.saraya.airportgeo.model.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportGeoRepository extends JpaRepository<AirportGeo, Long> {

    @Query("select a.id from AirportGeo a  where a.city=:city and a.country=:country")
    Long getIdAirportGeoByCityAndCountry(String city, String country);

    void deleteByCityAndCountry(String city, String country);

}
