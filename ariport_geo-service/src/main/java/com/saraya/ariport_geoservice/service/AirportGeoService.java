package com.saraya.ariport_geoservice.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.saraya.ariport_geoservice.model.AirportGeo;

@Service
public interface AirportGeoService {
	
	List<AirportGeo> getAll();
	
	AirportGeo getByCountryAndCity(String country, String city);
	
	AirportGeo getById(Long id);
	
	Long getAirportGeoId(String country, String city);
	
	AirportGeo create(AirportGeo airportGeo);
	
	AirportGeo update(AirportGeo airportGeo, Long id);
	
	void delete(Long id);
}
