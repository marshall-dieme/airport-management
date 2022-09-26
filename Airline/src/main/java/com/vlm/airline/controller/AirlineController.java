package com.vlm.airline.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.airline.exception.ResourceNotFoundException;
import com.vlm.airline.model.Airline;
import com.vlm.airline.repository.AirlineRepository;


@RestController
@RequestMapping("/api/")
public class AirlineController {
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	@GetMapping("/airlines")
	public List<Airline> getAllAirlines(){
		return airlineRepository.findAll();
	}
	
	@PostMapping("/airlines")
	public Airline createAirline(@RequestBody Airline airline) {
		return airlineRepository.save(airline);
	}
	
	@GetMapping("/airlines/{id}")
	public ResponseEntity<Airline> getParkingById(@PathVariable Long id){
		Airline airline = airlineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airline not exist with id :" + id));
		return ResponseEntity.ok(airline);
	}
	
	@PutMapping("/airlines/{id}")
	public ResponseEntity<Airline> updateParking(@PathVariable Long id, @RequestBody Airline airlineDetails){
		Airline airline = airlineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airline not exist with id :" + id));
		
		airline.setAirline_name(airlineDetails.getAirline_name());
		airline.setIata(airlineDetails.getIata());
		
		Airline updatedAirline = airlineRepository.save(airline);
		return ResponseEntity.ok(updatedAirline);
	}
	
	@DeleteMapping("/airlines/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAirline(@PathVariable Long id){
		Airline airline = airlineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airline not exist with id :" + id));
		
		airlineRepository.delete(airline);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
