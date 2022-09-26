package com.vlm.airplanetype.controller;

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

import com.vlm.airplanetype.exception.ResourceNotFoundException;
import com.vlm.airplanetype.model.Airplane;
import com.vlm.airplanetype.repository.AirplaneRepository;



@RestController
@RequestMapping("/api/v1/")
public class AirplaneController {
	
	@Autowired
	private AirplaneRepository airplaneRepository;
	
	@GetMapping("/airplanes")
	public List<Airplane> getAllAirplanes(){
		return airplaneRepository.findAll();
	}
	
	@PostMapping("/airplanes")
	public Airplane createEmployee(@RequestBody Airplane airplane) {
		return airplaneRepository.save(airplane);
	}
	
	@GetMapping("/airplanes/{id}")
	public ResponseEntity<Airplane> getAirplaneById(@PathVariable Long id){
		Airplane airplane = airplaneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airplane not exist with id :" + id));
		return ResponseEntity.ok(airplane);
    }
	
	@PutMapping("/airplanes/{id}")
	public ResponseEntity<Airplane> updateAirplane(@PathVariable Long id, @RequestBody Airplane airplaneDetails){
		Airplane airplane = airplaneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airplane not exist with id :" + id));
		
		airplane.setAirplane_type_identifier(airplaneDetails.getAirplane_type_identifier());
		airplane.setDescription(airplaneDetails.getDescription());
		
		Airplane updatedAirplane = airplaneRepository.save(airplane);
		return ResponseEntity.ok(updatedAirplane);
	}
	
	@DeleteMapping("/airplanes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAirplane(@PathVariable Long id){
		Airplane airplanee = airplaneRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airplane not exist with id :" + id));
		
		airplaneRepository.delete(airplanee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
