package com.saraya.AirplaneType.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.AirplaneType.dto.AirplaneTypeDTO;
import com.saraya.AirplaneType.services.AirplaneTypeService;



@RestController
public class AirplaneTypeController {
	@Autowired
	private AirplaneTypeService services;
	@PostMapping("/")
	public AirplaneTypeDTO create(@RequestBody AirplaneTypeDTO airplaneTypeDTO) {
		return services.create(airplaneTypeDTO);
	}
	
	@GetMapping("/list")
	public List<AirplaneTypeDTO> retrievePassengerDetails() {
		return services.getAllAirplaneType();
	}
	
	@GetMapping("/{id}")
	public AirplaneTypeDTO create(@PathVariable Long id) {
		return services.getAirplaneType(id);
	}
	
	@PutMapping("/update/{id}")
	public AirplaneTypeDTO update(@RequestBody AirplaneTypeDTO airplaneTypeDTO, @PathVariable Long id) {
		return services.update(airplaneTypeDTO, id);
	}
	
	@DeleteMapping("/delete")
	public void delete(@PathVariable Long id) {
		services.delete(id);
	}
}
