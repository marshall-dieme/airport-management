package com.saraya.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.saraya.airline.dto.AirlineDTO;
import com.saraya.airline.services.Services;

@RestController
@RequestMapping("/Airline")
public class AirlineController {
	@Autowired
	private Services services;
	
	@PostMapping("/createAirline")
	public ResponseEntity<AirlineDTO> createAirline(@RequestBody AirlineDTO airlineDTO) {
		airlineDTO = services.saveAirline(airlineDTO);
		ResponseEntity<AirlineDTO> responseEntity = new ResponseEntity<AirlineDTO>(airlineDTO, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/Airline-list")
	public ResponseEntity<List<AirlineDTO>> retreiveAirline() {
		List<AirlineDTO> airlines = services.getAllAirline();
		ResponseEntity<List<AirlineDTO>> responseEntity = new ResponseEntity<List<AirlineDTO>>(airlines, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AirlineDTO> showAirline(@PathVariable Long id) {
		AirlineDTO airline = services.AirlineById(id);
		ResponseEntity<AirlineDTO> responseEntity = new ResponseEntity<AirlineDTO>(airline, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/updateAirline/{id}")
	public ResponseEntity<AirlineDTO> updateAirline(@RequestBody AirlineDTO airlineDTO, @PathVariable Long id) {
		airlineDTO = services.updateAirline(airlineDTO, id);
		ResponseEntity<AirlineDTO> responseEntity = new ResponseEntity<AirlineDTO>(airlineDTO, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/deleteAirline/{id}")
	public ResponseEntity<Void> deleteAirline(@PathVariable Long id) {
		services.deleteAirline(id);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		return responseEntity;
	}
}
