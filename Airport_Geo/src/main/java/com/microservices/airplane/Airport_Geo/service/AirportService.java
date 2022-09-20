package com.microservices.airplane.Airport_Geo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.airplane.Airport_Geo.entity.AirportGeo;
import com.microservices.airplane.Airport_Geo.repository.AirportRepository;

@Service
public class AirportService {

	
	private final AirportRepository repo;

	public AirportService(AirportRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public List<AirportGeo> ListAirport(){
		return repo.findAll();
	}
	
	
	public AirportGeo saveAirport(AirportGeo airportGeo) {
		airportGeo.generateId();
		return repo.save(airportGeo);
	}
	
	
	
	
	public AirportGeo getId(String id) {
		return repo.findById(id).get();
	}
	
	
	public AirportGeo update(AirportGeo airportGeo) {
		return repo.save(airportGeo);
		
	}
	
	
	public void delete(AirportGeo airport) {
		 repo.delete(airport);
	}
	
	
	
	public AirportGeo getCountry(String country) {
		return repo.findByCountry(country);
	}
	
	
	
	
}
