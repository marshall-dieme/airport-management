package com.saraya.Airport.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.Airport.model.AirportModel;
import com.saraya.Airport.service.AirportService;




@RestController
@RequestMapping("/airport")
public class AirportContoller {

	
	
	@Autowired
	private AirportService service;
   

	@GetMapping
	public List<AirportModel> getAirport() {
	return service.getListAirport();
		
	}
	
	@GetMapping("/{id}")
	public Optional<AirportModel> getById(@PathVariable("id") int id) {
		return service.getBId(id);
	}
	
	@PostMapping
	public AirportModel create1(@RequestBody AirportModel airportmodel) {
		
		return service.createAirport(airportmodel);
	}
	
	@PutMapping
	public AirportModel update1(@RequestBody AirportModel airportmodel) {
		return service.createAirport(airportmodel);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAirport(@PathVariable int id) {
		service.delete(id);
	}
	
}
	
