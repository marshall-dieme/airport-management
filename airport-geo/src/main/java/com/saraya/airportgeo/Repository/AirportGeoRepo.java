package com.saraya.airportgeo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.airportgeo.model.Airport_Geo;
@Repository
public interface AirportGeoRepo extends JpaRepository<Airport_Geo , Integer>{

	Airport_Geo findByCountry( String country);

	void deleteByCountry( String country);
	

}
