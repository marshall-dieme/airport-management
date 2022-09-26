package com.example.airplaneservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airplaneservice.model.AirplaneDTO;
import com.example.airplaneservice.service.AirplaneServiceImpl;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {
	
	private final AirplaneServiceImpl service;
	
	public AirplaneController(AirplaneServiceImpl airplaneServiceImpl) {
		service = airplaneServiceImpl;
	}
	
	@GetMapping
	public List<AirplaneDTO> getAll() {
		return service.getAllAirplane();
	}

	@GetMapping("/{id}")
	public AirplaneDTO getById(@PathVariable Long id) {
		return service.getAirplaneById(id);
	}
	
	@PostMapping
	public AirplaneDTO create (@RequestBody AirplaneDTO airplaneDTO) {
		return service.createAirplane(airplaneDTO);
	}
	
	@PutMapping("/update/{id}")
	public AirplaneDTO update(@RequestBody AirplaneDTO airplaneDTO, Long id) {
		return service.updateAiplane(airplaneDTO, id);
				
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteAirplane(id);
	}
}
