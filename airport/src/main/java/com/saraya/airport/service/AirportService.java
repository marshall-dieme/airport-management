package com.saraya.airport.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saraya.airport.model.Airport;
import com.saraya.airport.model.AirportDTO;

@Service
public interface AirportService {
	
	List<Airport> getAll();
	
	Airport getById(Long id);
	
	Long getByName(String airportName);
	
	Airport getAirportByAirportGeo(String country, String city);
	
	Airport create(AirportDTO dto);
	
	AirportDTO update(AirportDTO dto, Long id);
	
	void delete(Long id);

}
