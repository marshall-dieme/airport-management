package com.saraya.parking.controller;

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

import com.saraya.parking.dto.ParkingDTO;
import com.saraya.parking.services.ParkingSrevices;
import com.saraya.parking.services.impl.ParkingServiceImpl;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	@Autowired
	private ParkingSrevices services;
	@PostMapping("/")
	public ParkingDTO create(@RequestBody ParkingDTO dto) {
		return services.createParking(dto);
	}
	
	@GetMapping("/list")
	public List<ParkingDTO> retrieveFlight() {
		return services.getAllParking();
	}
	
	@GetMapping("/{id}")
	public ParkingDTO create(@PathVariable Long id) {
		return services.getParking(id);
	}
	
	@PutMapping("/update/{id}")
	public ParkingDTO update(@RequestBody ParkingDTO dto, @PathVariable Long id) {
		return services.updateParking(dto, id);
	}
	
	@DeleteMapping("/delete")
	public void delete(@PathVariable Long id) {
		services.deleteParking(id);
	}
}
