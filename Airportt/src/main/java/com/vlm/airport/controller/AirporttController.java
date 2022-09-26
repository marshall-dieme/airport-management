package com.vlm.airport.controller;

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

import com.vlm.airport.exception.ResourceNotFoundException;
import com.vlm.airport.model.Airportt;
import com.vlm.airport.repository.AirporttRepository;


@RestController
@RequestMapping("/api/v1/")
public class AirporttController {

	@Autowired
	private AirporttRepository airporttRepository;
	
	@GetMapping("/flights")
	public List<Airportt> getAllAirportts(){
		return airporttRepository.findAll();
	}
	
	@PostMapping("/flights")
	public Airportt createAirportt(@RequestBody Airportt airportt) {
		return airporttRepository.save(airportt);
	}
	
	@GetMapping("/flights/{id}")
	public ResponseEntity<Airportt> getAirporttById(@PathVariable Long id){
		Airportt airportt = airporttRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airportt not exist with id :" + id));
		return ResponseEntity.ok(airportt);
	}
	
	@PutMapping("/flights/{id}")
	public ResponseEntity<Airportt> updateAirportt(@PathVariable Long id, @RequestBody Airportt airporttDetails){
		Airportt airportt = airporttRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airportt not exist with id :" + id));
		
		airportt.setIata(airporttDetails.getIata());
		airportt.setIcao(airporttDetails.getIcao());
		airportt.setAirport_name(airporttDetails.getAirport_name());
		
		Airportt updatedEmployee = airporttRepository.save(airportt);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/flights/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAirportt(@PathVariable Long id){
		Airportt airportt = airporttRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airportt not exist with id :" + id));
		
		airporttRepository.delete(airportt);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
