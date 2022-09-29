package com.geo.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.geo.airporgeo.Airport_Geo;




@FeignClient(name= "Airport_Geo")
public interface airportgeo_feignclient {
	@GetMapping("/airports_geo/{airportgeoid}")
	List<Airport_Geo> findByAirportGeo(@PathVariable("airportgeoid") Long airportgeoid);
	
	
}