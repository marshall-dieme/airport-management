package com.airport_geo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airport_geo.entities.Airport_Geo;

@Repository
public interface Airport_Geo_Dao extends JpaRepository<Airport_Geo, Long>{

}
