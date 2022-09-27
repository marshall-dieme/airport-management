package com.saraya.microservices.airportmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saraya.microservices.airportmanagement.model.Airport_Geo;
import com.saraya.microservices.airportmanagement.model.Airport_Geo_DTO;


@Service
public interface AirGeoService{
	
	public List<Airport_Geo> listAirpGeo();
	
	public Airport_Geo createAirportGeo(Airport_Geo_DTO dto);
	
	public Airport_Geo updateAirportGeo(Airport_Geo_DTO dto);
	
	public void deleteAirportGeo(Long airport_Geo_id);
	
	public String getIdAirport(String name);
	
	
}
