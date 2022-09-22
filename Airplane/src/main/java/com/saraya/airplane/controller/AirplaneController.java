package com.saraya.airplane.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.saraya.airplane.dto.AirplaneDTO;
import com.saraya.airplane.services.Services;



@RestController
public class AirplaneController {
	@Autowired
	private Services services;
	
	@PostMapping("/createAirline")
	public ResponseEntity<AirplaneDTO> createAirline(@RequestBody AirplaneDTO airplaneDTO) {
		airplaneDTO = services.saveAirplane(airplaneDTO);
		ResponseEntity<AirplaneDTO> responseEntity = new ResponseEntity<AirplaneDTO>(airplaneDTO, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/Airplane-list")
	public ResponseEntity<List<AirplaneDTO>> retreiveAirplane() {
		List<AirplaneDTO> airlines = services.getAllAirplane();
		ResponseEntity<List<AirplaneDTO>> responseEntity = new ResponseEntity<List<AirplaneDTO>>(airlines, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AirplaneDTO> showAirline(@PathVariable Long id) {
		AirplaneDTO airline = services.AirlineById(id);
		ResponseEntity<AirplaneDTO> responseEntity = new ResponseEntity<AirplaneDTO>(airline, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/updateAirplane/{id}")
	public ResponseEntity<AirplaneDTO> updateAirline(@RequestBody AirplaneDTO airplaneDTO, @PathVariable Long id) {
		airplaneDTO = services.updateAirplane(airplaneDTO, id);
		ResponseEntity<AirplaneDTO> responseEntity = new ResponseEntity<AirplaneDTO>(airplaneDTO, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/deleteAirplane/{id}")
	public ResponseEntity<Void> deleteAirline(@PathVariable Long id) {
		services.deleteAirplane(id);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		return responseEntity;
	}
}
