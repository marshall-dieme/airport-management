package com.saraya.flight.controller;

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

import com.saraya.flight.dto.FlightDTO;
import com.saraya.flight.services.FlightServices;

@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired
	private FlightServices flightServices;
	@PostMapping("/")
	public FlightDTO create(@RequestBody FlightDTO dto) {
		return flightServices.createFlight(dto);
	}
	
	@GetMapping("/list")
	public List<FlightDTO> retrieveFlight() {
		return flightServices.getAllFlight();
	}
	
	@GetMapping("/{id}")
	public FlightDTO create(@PathVariable Long id) {
		return flightServices.getFlight(id);
	}
	
	@PutMapping("/update/{id}")
	public FlightDTO update(@RequestBody FlightDTO dto, @PathVariable Long id) {
		return flightServices.updateFlight(dto, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		flightServices.deleteFlight(id);
	}
}
