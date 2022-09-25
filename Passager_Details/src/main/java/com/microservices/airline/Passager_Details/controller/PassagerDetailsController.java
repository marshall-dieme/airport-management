package com.microservices.airline.Passager_Details.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.airline.Passager_Details.entity.PassagerDetails;
import com.microservices.airline.Passager_Details.entity.PassagerDetailsDto;
import com.microservices.airline.Passager_Details.service.PassagerDetailsService;

@RestController
@RequestMapping("/passagerdetails")
public class PassagerDetailsController {
	
	private final PassagerDetailsService service;

	public PassagerDetailsController(PassagerDetailsService service) {
		super();
		this.service = service;
	}
	
	
	
	@GetMapping
	public List<PassagerDetails> getAllPassDetails() {
		return service.getPassagerDetails();
	}
	
	
	@GetMapping("/{id}")
	public PassagerDetails getById(@PathVariable String id) {
		return service.getById(id).get();
	}
	
	
	
	
	@PostMapping
	public PassagerDetails create(@RequestBody PassagerDetailsDto dto) {
		return service.create(dto);
	}
	
	
	
	@PutMapping
	public PassagerDetails update(@RequestBody PassagerDetailsDto dto) {
		return service.update(dto);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		service.delete(id);
	}
	

	
	
	@GetMapping("/passager/{passportno}")
	public PassagerDetails findPassagerDetailsByPasser(@PathVariable String passportno) {
		return service.findDetailsByPassager(passportno);
	}
	
	
	
}
