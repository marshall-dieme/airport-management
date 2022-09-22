package com.saraya.airport_geoservice.repo;

import com.saraya.airport_geoservice.model.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AirportGeorRepo extends JpaRepository<AirportGeo, Long> {

  //  void delete(Long airport_geo_id);

    AirportGeo findByCountryAndCity(String country, String city);
}
