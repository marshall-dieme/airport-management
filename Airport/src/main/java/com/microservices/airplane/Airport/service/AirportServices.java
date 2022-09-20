package com.microservices.airplane.Airport.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.airplane.Airport.entity.Airport;
import com.microservices.airplane.Airport.repository.AirportRepository;



@Service
public class AirportServices {

	
	private final AirportRepository repos;
	
	public AirportServices(AirportRepository repos) {
		super();
		this.repos = repos;
	}


	public List<Airport> ListAirports(){
		return repos.findAll();
	}
	
	
	public Airport saveAirport(Airport airport) {
		airport.generateId();
		return repos.save(airport);
	}
	
	
	public Airport getId(String id) {
		return repos.findById(id).get();
	}
	
	
	public Airport update(Airport airport) {
		return repos.save(airport);
		
	}
	
	
	public void delete(String id) {
		 repos.deleteById(id);
	}
	
	
//	public Airport getAirportName(String airport_name) {
//		return repos.findByAirportName(airport_name);
//	}
	
	
}
