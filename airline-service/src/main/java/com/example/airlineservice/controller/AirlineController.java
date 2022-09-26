package com.example.airlineservice.controller;

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

import com.example.airlineservice.model.AirlineDTO;
import com.example.airlineservice.service.AirlineServiceImpl;

@RestController
@RequestMapping("/airline")
public class AirlineController {
	
	@Autowired
	private final AirlineServiceImpl service;
	
	public AirlineController(AirlineServiceImpl airlineServiceImpl) {
		this.service = airlineServiceImpl;
	}

	@GetMapping
	public List<AirlineDTO> getAllAirline() {
		return service.getAll();
	}
	@GetMapping("/{id}")
	public AirlineDTO getAirlineById(@PathVariable Long id) {
		return service.getAilineById(id);
	}
	
	@PostMapping
	public AirlineDTO create(@RequestBody AirlineDTO airlineDTO) {
		return service.createAirline(airlineDTO);
	}
	
	@PutMapping("/update/{id}")
	public AirlineDTO update(@RequestBody AirlineDTO airlineDTO, @PathVariable Long id) {
		return service.updateAirline(airlineDTO, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteAirline(id);
	}
}
