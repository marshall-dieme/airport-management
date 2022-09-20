package com.microservices.airplane.Airport.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.airplane.Airport.entity.Airport;
import com.microservices.airplane.Airport.service.AirportServices;

@RestController
@RequestMapping("/airports")
public class AirportsController {

	private final AirportServices service;

	public AirportsController(AirportServices service) {
		super();
		this.service = service;
	}
	
	
	
	@GetMapping
	public List<Airport> ListAirport(){
		return service.ListAirports();
	}
	
	
	@GetMapping("/{airport_id}")
	public Airport getById(@PathVariable String airport_id) {
		return service.getId(airport_id);
	}
	
	
//	@GetMapping("/name/{airport_name}")
//	public Airport getByAirportName(@PathVariable String airport_name) {
//		return service.getAirportName(airport_name);
//	}
	
	
	
	@PostMapping
	public Airport create(@RequestBody Airport airport) {
		return service.saveAirport(airport);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String airport_id) {
		service.delete(airport_id);
	}
	
	
	@PutMapping
	public Airport edit(@RequestBody Airport airport) {
		return service.update(airport);
	}
	
	
}
