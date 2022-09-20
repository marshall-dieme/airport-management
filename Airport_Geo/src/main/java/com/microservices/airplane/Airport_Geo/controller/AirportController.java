package com.microservices.airplane.Airport_Geo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.airplane.Airport_Geo.entity.AirportGeo;
import com.microservices.airplane.Airport_Geo.service.AirportService;

@RestController
@RequestMapping("/airportGeo")
public class AirportController {

	
	@Autowired
	private AirportService service;
	
	
	@GetMapping
	public  List<AirportGeo> getAll(){
		return service.ListAirport();
	}
	
	
	
	@PostMapping
	public AirportGeo save(@RequestBody AirportGeo airportGeo) {
		return service.saveAirport(airportGeo);
	}
	
	
	@GetMapping("/{id}")
	public AirportGeo getbyId(@PathVariable String id) {
		return service.getId(id);
		
	}
	
	@PutMapping
	public AirportGeo update(@RequestBody AirportGeo airportGeo) {
		return service.update(airportGeo);
	}
	
	
	
	@DeleteMapping
	public void delete( AirportGeo airportGeo) {
		service.delete(airportGeo);
	}
	
	
	
	@GetMapping("/country/{country}")
	public AirportGeo getbycountry(@PathVariable String country) {
		return service.getCountry(country);
	}
	
	
	
}
