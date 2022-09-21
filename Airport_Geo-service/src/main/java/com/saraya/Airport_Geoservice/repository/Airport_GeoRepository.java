package com.saraya.Airport_Geoservice.repository;

import com.saraya.Airport_Geoservice.model.Airport_Geo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Airport_GeoRepository extends JpaRepository<Airport_Geo,Long> {
}
