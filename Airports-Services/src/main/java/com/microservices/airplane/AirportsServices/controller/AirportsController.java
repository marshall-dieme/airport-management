package com.microservices.airplane.AirportsServices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.airplane.AirportsServices.entity.AirportDto;
import com.microservices.airplane.AirportsServices.entity.Airports;
import com.microservices.airplane.AirportsServices.service.AirportsService;

@RestController
@RequestMapping("/airports")
public class AirportsController {

	public final AirportsService service;

	public AirportsController(AirportsService service) {
		super();
		this.service = service;
	}
	
	
	
	@GetMapping
	public List<Airports> getAlls(){
		return service.getAll();
	}
	
	
	@GetMapping("/{id}")
	public Airports getById(@PathVariable String airport_id) {
		return service.getById(airport_id);
	}
	
	@PostMapping
	public Airports create(@RequestBody AirportDto dto) {
		return service.create(dto);
	}
	
	
	@PutMapping
	public Airports updatr(@RequestBody AirportDto dto) {
		return service.update(dto);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String airport_id) {
		service.delete(airport_id);
	}
	
	
	@GetMapping("/name/{airportname}")
	public String getIdAirport(@PathVariable String airportname) {
		return service.getIdAirport(airportname);
	}
	
	
	
	@GetMapping("/{country}/{city}")
	public Airports findAirportByAirportGeo(@PathVariable String country, @PathVariable String city) {
		return service.findAirportByAirportGeo(country, city);
	}
	
	
	
	
	
}
