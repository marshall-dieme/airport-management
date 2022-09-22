package com.saraya.Airport_Geo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.Airport_Geo.Model.Airport_GeoModel;
import com.saraya.Airport_Geo.service.Airport_Geoservice;

@RestController
@RequestMapping("/airport_geo")
public class Airport_GeoController {

	
	@Autowired
	private Airport_Geoservice service;
   

	@GetMapping
	public List<Airport_GeoModel> getAirport_Geo() {
	return service.getListAirport();
		
	}
	
	@GetMapping("/{id}")
	public Airport_GeoModel getById(@PathVariable("id") int id) {
		return service.getBId(id);
	}
	
	@PostMapping
	public Airport_GeoModel create1(@RequestBody Airport_GeoModel airport_geomodel) {
		
		return service.createAirport(airport_geomodel);
	}
	
	@PutMapping
	public Airport_GeoModel update1(@RequestBody Airport_GeoModel airport_geomodel) {
		return service.createAirport(airport_geomodel);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAirport_Geo(@PathVariable int id) {
		service.delete(id);
	}
	
	
	@GetMapping("/country/{Country}")
	public Airport_GeoModel getAirport_Geo(@PathVariable String Country) {
	
	return service.getAirport_Geo(Country);
	
	}
	
	
}
