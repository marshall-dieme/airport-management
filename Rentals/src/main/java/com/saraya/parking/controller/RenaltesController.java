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

import com.saraya.parking.dto.RenaltsDTO;
import com.saraya.parking.mapper.ConvertRentals;
import com.saraya.parking.model.Rentals;
import com.saraya.parking.repository.RenaltesRepository;
import com.saraya.parking.services.RenaltsServices;

@RestController
@RequestMapping("/renaltes")
public class RenaltesController {
	@Autowired
	private RenaltsServices services;
	@PostMapping("/creatRentals")
	public RenaltsDTO creatRentals(@RequestBody RenaltsDTO dto) {
		return services.create(dto);
	}
	
	@GetMapping("/list")
	public List<RenaltsDTO> retrieve() {
		
		return services.getAllRenaltes();
	}
	
	@GetMapping("/{id}")
	public RenaltsDTO create(@PathVariable Long id) {
		return services.getRenalts(id);
	}
	
	@PutMapping("/update/{id}")
	public RenaltsDTO update(@RequestBody RenaltsDTO dto, @PathVariable Long id) {
		return services.update(dto, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		 services.delete(id);
	}
}
