package com.vlm.airportgeo.controller;

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

import com.vlm.airportgeo.exception.ResourceNotFoundException;
import com.vlm.airportgeo.model.Airportgeo;
import com.vlm.airportgeo.repository.AirportgeoRepository;

@RestController
@RequestMapping("/api/v1/")
public class AirportgeoControler {
	
	@Autowired
	private AirportgeoRepository airportgeoRepository;
	
	@GetMapping("/airports")
	public List<Airportgeo> getAllAirportgeos(){
		return airportgeoRepository.findAll();
	}
	
	@PostMapping("/airports")
	public Airportgeo createAirportgeo(@RequestBody Airportgeo employee) {
		return airportgeoRepository.save(employee);
	}
	
	@GetMapping("/airports/{id}")
	public ResponseEntity<Airportgeo> getAirportgeoById(@PathVariable Long id){
		Airportgeo airportgeo = airportgeoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airportgeo not exist with id :" + id));
		return ResponseEntity.ok(airportgeo);
	}
	
	@PutMapping("/airports/{id}")
	public ResponseEntity<Airportgeo> updateAirportgeo(@PathVariable Long id, @RequestBody Airportgeo airportgeoDetails){
		Airportgeo airportgeo = airportgeoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airportgeo not exist with id :" + id));
		
		airportgeo.setCountry(airportgeoDetails.getCountry());
		airportgeo.setCity(airportgeoDetails.getCity());
		
		Airportgeo updatedAirportgeo = airportgeoRepository.save(airportgeo);
		return ResponseEntity.ok(updatedAirportgeo);
	}
	
	@DeleteMapping("/airports/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAirportgeo(@PathVariable Long id){
		Airportgeo airportgeo = airportgeoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airportgeo not exist with id :" + id));
		
		airportgeoRepository.delete(airportgeo);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
