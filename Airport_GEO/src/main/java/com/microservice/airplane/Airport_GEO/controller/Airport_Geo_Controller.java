package com.microservice.airplane.Airport_GEO.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.airplane.Airport_GEO.Enitity.Airport_Geo;
import com.microservice.airplane.Airport_GEO.service.Airport_Geo_service;



@RestController
@RequestMapping("airport_Geo")
public class Airport_Geo_Controller {
	
	private final Airport_Geo_service service;
	
	public Airport_Geo_Controller(Airport_Geo_service service) {
		
		this.service = service;
	}
	
	@GetMapping("/")
	public List<Airport_Geo> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{aiport_geo_id}")
	public Optional<Airport_Geo> getById(@PathVariable Long aiport_geo_id) {
		
		return service.getById(aiport_geo_id);
	}
	
	@PostMapping("/create")
	public Airport_Geo create(@RequestBody Airport_Geo aGeo) {
		return service.create(aGeo);
	}
	
	@PutMapping
	public Airport_Geo update(@RequestBody Airport_Geo aGeo) {
		return service.update(aGeo);
	}
	
	@DeleteMapping("/{aiport_geo_id}")
	 public void deleteByID(@PathVariable Long aiport_geo_id) {
		service.delete(aiport_geo_id);
	}
	
	@GetMapping("/country-city/{country}/{city}")
	public String getIdGeo(@PathVariable String country , @PathVariable String city) {
		
		return service.getIdGeo(country, city);
	}
	
	


}
