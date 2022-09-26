package com.vlm.airportgeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlm.airportgeo.model.Airportgeo;

@Repository
public interface AirportgeoRepository extends JpaRepository<Airportgeo, Long> {

}
