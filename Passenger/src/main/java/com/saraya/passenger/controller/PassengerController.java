package com.saraya.passenger.controller;

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

import com.saraya.passenger.dto.PassengerDTO;
import com.saraya.passenger.services.PassengerServices;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
	@Autowired
	private PassengerServices passengerServices;
	@PostMapping("/creatPassenger")
	public PassengerDTO creatPassenger(@RequestBody PassengerDTO passengerDTO) {
		return passengerServices.createPassenger(passengerDTO);
	}
	
	@GetMapping("/listPassenger")
	public List<PassengerDTO> retrievePassenger() {
		return passengerServices.getAllPassenger();
	}
	
	@GetMapping("/{id}")
	public PassengerDTO showPassenger(@PathVariable Long id) {
		return passengerServices.getPassenger(id);
	}
	
	@PutMapping("/updatePassenger/{id}")
	public PassengerDTO updatePassenger(@RequestBody PassengerDTO dto,@PathVariable Long id) {
		return passengerServices.updatePassenger(dto, id);
	}
	@DeleteMapping("/deletePassenger/{id}")
	public void deletePassenger(@PathVariable Long id) {
		passengerServices.deletePassenger(id);
	}
}
