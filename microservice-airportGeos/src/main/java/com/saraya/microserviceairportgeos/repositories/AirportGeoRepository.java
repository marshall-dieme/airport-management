package com.saraya.microserviceairportgeos.repositories;


import com.saraya.microserviceairportgeos.models.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportGeoRepository extends JpaRepository<AirportGeo,Long> {
}
