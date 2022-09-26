package com.saraya.services.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.saraya.services.model.Services;
import com.saraya.services.model.ServicesDTO;
import com.saraya.services.service.Servicesservice;

@RestController
@RequestMapping("/services")
public class ServicesController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ServicesController.class);
	
	private final Servicesservice service;
	
	public ServicesController(Servicesservice serv) {
		service = serv;
	}
	
	@GetMapping
	public List<ServicesDTO> getAll(){
		return service.getAll();
	}
	@GetMapping("/{id}")
	public ServicesDTO getById(@PathVariable Long id) {
		return service.getById(id);
	}
	@PostMapping
	public ResponseEntity<Services> create(@RequestBody ServicesDTO dto) {
		
		service.create(dto);
		ResponseEntity<Services> responseEntity = new ResponseEntity<Services>(HttpStatus.CREATED);
		
		return responseEntity;
	}
	@GetMapping("/{airportName}/airports")
    public List <Services>  getServicesByAiport(@PathVariable String airportName) {
        return service.getServicesByAirport(airportName);
    }
	 @PutMapping("/update/{id}")
	    public ServicesDTO update(@RequestBody ServicesDTO dto, @PathVariable Long id) {
	    	return service.update(dto,id);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	    	service.delete(id);
	    }
}

