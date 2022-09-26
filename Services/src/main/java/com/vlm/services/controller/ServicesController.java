package com.vlm.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.services.exception.ResourceNotFoundException;
import com.vlm.services.model.Services;
import com.vlm.services.repository.ServiceRepository;


@RestController
@RequestMapping("/api/v1/")
public class ServicesController {
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@GetMapping("/servicess")
	public List<Services> getAllServicess(){
		return serviceRepository.findAll();
	}
	
	@GetMapping("/servicess/{id}")
	public ResponseEntity<Services> getServicesById(@PathVariable Long id){
		Services services = serviceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Services not exist with id :" + id));
		return ResponseEntity.ok(services);
	}

}
