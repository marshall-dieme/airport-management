package com.saraya.airportgeo.repository;


import com.saraya.airportgeo.entity.AirportGeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<AirportGeo, Long> {
         AirportGeo findById(long id);

}
