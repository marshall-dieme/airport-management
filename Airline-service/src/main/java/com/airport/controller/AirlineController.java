package com.airport.controller;

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

import com.airport.entities.Airline;
import com.airport.service.AirlineService;

@RestController
@RequestMapping("/")
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;

	public AirlineController(AirlineService airlineService) {
		super();
		this.airlineService = airlineService;
	}
	@GetMapping("/")
	public List<Airline> getAll(){
		return airlineService.getAll();
	}
	 @GetMapping("/{id}")
	public Airline getById(@PathVariable long id) {
		return airlineService.getById(id);
	}
	 @PostMapping("/")
	public Airline create(@RequestBody Airline airline) {
		return airlineService.create(airline);
	}
	 @PutMapping("/")
		public Airline update(@RequestBody Airline airline) {
			return airlineService.update(airline);
}
	 @DeleteMapping("/")
	 public void delete(@PathVariable long id) {
		 airlineService.delete(id);
	 }
}
