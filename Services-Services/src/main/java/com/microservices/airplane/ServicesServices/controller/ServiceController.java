package com.microservices.airplane.ServicesServices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.microservices.airplane.ServicesServices.entity.ServiceDto;
import com.microservices.airplane.ServicesServices.entity.Services;
import com.microservices.airplane.ServicesServices.service.ServicesService;

@RestController
@RequestMapping("/services")
public class ServiceController {

	private final ServicesService se;

	public ServiceController(ServicesService se) {
		super();
		this.se = se;
	}
	
	@GetMapping
	public List<Services> getAlls(){
		return se.getService();
	}
	
	
	@GetMapping("/{id}")
	public Services getById(@PathVariable int id) {
		return se.getById(id);
	
	}
	
	
	@PostMapping
	public Services create(@RequestBody ServiceDto dto) {
		return se.create(dto);
				
	}
	
	
	@PutMapping
	public Services update(@RequestBody ServiceDto dto) {
		return se.update(dto);
				
	}
	
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		se.delete(id);
	}
	
	
	@GetMapping("/{airportname}/services")
	 public List<Services> getServicesByAirports(@PathVariable String airportname) {
        return se.getByAirports(airportname);
    }
				
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
