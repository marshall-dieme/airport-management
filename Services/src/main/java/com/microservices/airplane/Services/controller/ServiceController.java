package com.microservices.airplane.Services.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.airplane.Services.entity.Services;
import com.microservices.airplane.Services.service.ServiceService;

@RestController
@RequestMapping("/services")
public class ServiceController {

	private final ServiceService serv;

	public ServiceController(ServiceService serv) {
		super();
		this.serv = serv;
	}
	
	@GetMapping
	public List<Services> ListServices(){
		return serv.ListServices();
	}
	
	
	@GetMapping("/{service_id}")
	public Services getById(@PathVariable String service_id) {
		return serv.getId(service_id);
	}

	
	
	
	@PostMapping
	public Services create(@RequestBody Services service) {
		return serv.saveService(service);
	}
	
	
	@DeleteMapping("/{service_id}")
	public void delete(@PathVariable String service_id) {
		serv.delete(service_id);
	}
	
	
	@PutMapping
	public Services edit(@RequestBody Services service) {
		return serv.update(service);
	}
	
	
	
	
	
}
