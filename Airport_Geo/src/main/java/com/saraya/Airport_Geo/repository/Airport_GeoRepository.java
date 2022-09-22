package com.saraya.Airport_Geo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.Airport_Geo.Model.Airport_GeoModel;



@Repository
public interface Airport_GeoRepository extends JpaRepository<Airport_GeoModel,Integer>  {

	Airport_GeoModel findByCountry(String country);

	
}

