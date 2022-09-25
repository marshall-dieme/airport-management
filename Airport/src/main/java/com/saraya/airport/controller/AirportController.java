package com.saraya.airport.controller;

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

import com.saraya.airport.dto.AiportDTO;
import com.saraya.airport.services.AirportService;

@RestController
@RequestMapping("/Airport")
public class AirportController {
	@Autowired
	private AirportService airportService;
	
	@PostMapping("/createAirport")
	public ResponseEntity<AiportDTO> createAirport(@RequestBody AiportDTO aiportDTO) {
		aiportDTO = airportService.create(aiportDTO);
		ResponseEntity<AiportDTO> responseEntity = new ResponseEntity<AiportDTO>(aiportDTO, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/ListOfAirport")
	public ResponseEntity<List<AiportDTO>> retreiveAirport() {
		List<AiportDTO> airports = airportService.getAllAirport();
		ResponseEntity<List<AiportDTO>> responseEntity = new ResponseEntity<List<AiportDTO>>(airports, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/showAirport/{id}")
	public ResponseEntity<AiportDTO> AirportById(@PathVariable Long id) {
		AiportDTO airport = airportService.showAirport(id);
		ResponseEntity<AiportDTO> responseEntity = new ResponseEntity<AiportDTO>(airport, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/updateAirport/{id}")
	public ResponseEntity<AiportDTO> updateAirport(@RequestBody AiportDTO aiportDTO, @PathVariable Long id) {
		aiportDTO = airportService.updateAirport(aiportDTO, id);
		ResponseEntity<AiportDTO> responseEntity = new ResponseEntity<AiportDTO>(aiportDTO, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/deleteAirport/{id}")
	public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
		airportService.deleteAirport(id);
		 ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		return responseEntity;
	}
	
}







