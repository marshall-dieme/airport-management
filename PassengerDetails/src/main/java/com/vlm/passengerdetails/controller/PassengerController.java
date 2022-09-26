package com.vlm.passengerdetails.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlm.passengerdetails.exception.ResourceNotFoundException;
import com.vlm.passengerdetails.model.Passenger;
import com.vlm.passengerdetails.repository.PassengerRepository;

@RestController
@RequestMapping("/api/")
public class PassengerController {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@GetMapping("/passengers")
	public List<Passenger> getAllPassengers(){
		return passengerRepository.findAll();
	}
	
	@PostMapping("/passengers")
	public Passenger createParking(@RequestBody Passenger passenger) {
		return passengerRepository.save(passenger);
	}
	
	@GetMapping("/passengers/{id}")
	public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id){
		Passenger passenger = passengerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Passenger not exist with id :" + id));
		return ResponseEntity.ok(passenger);
	}

	@PutMapping("/passengers/{id}")
	public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passengerDetails){
		Passenger passenger = passengerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Passenger not exist with id :" + id));
		
		passenger.setBirthdate(passengerDetails.getBirthdate());
		passenger.setSex(passengerDetails.getSex());
		passenger.setStreet(passengerDetails.getStreet());
		passenger.setCity(passengerDetails.getCity());
		passenger.setZip(passengerDetails.getZip());
		passenger.setCountry(passengerDetails.getCountry());
		passenger.setEmail(passengerDetails.getEmail());
		passenger.setTelephone(passengerDetails.getTelephone());
		
		Passenger updatedPassenger = passengerRepository.save(passenger);
		return ResponseEntity.ok(updatedPassenger);
	}
	
	@DeleteMapping("/passengers/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePassenger(@PathVariable Long id){
		Passenger passenger = passengerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Passenger not exist with id :" + id));
		
		passengerRepository.delete(passenger);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
