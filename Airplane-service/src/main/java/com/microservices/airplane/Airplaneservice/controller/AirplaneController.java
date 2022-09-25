package com.microservices.airplane.Airplaneservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.airplane.Airplaneservice.entity.Airplane;
import com.microservices.airplane.Airplaneservice.entity.AirplaneDto;
import com.microservices.airplane.Airplaneservice.service.AirplaneService;


@RestController
@RequestMapping("airplane")
public class AirplaneController {
	
	private final AirplaneService service;

	public AirplaneController(AirplaneService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	public List<Airplane> getAll(){
		return service.getAllAirplane();
	}
	
	
	@GetMapping("/{id}")
	public Airplane getById(@PathVariable String id) {
		return service.getById(id).get();
	}

	
	@PostMapping
	public Airplane create(@RequestBody AirplaneDto dto) {
		return service.create(dto);
	}
	

	
	@PutMapping
	public Airplane update(@RequestBody AirplaneDto dto) {
		return service.update(dto);
	}
	
	
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {	
		service.delete(id);
	}
	
	
	@GetMapping("/capacity/{capacity}")
	public String getListAirplaneByAirline(@PathVariable String capacity) {
		return service.getAirplaneByAirlin(capacity);
	}
	
	
	@GetMapping("/{airlinename}/airplane")
	 public List<Airplane> getAirplaneByAirline(@PathVariable String airlinename) {
       return service.getByAirline(airlinename);
	}
	
	
}
