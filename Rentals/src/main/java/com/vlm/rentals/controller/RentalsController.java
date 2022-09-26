package com.vlm.rentals.controller;

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

import com.vlm.rentals.exception.ResourceNotFoundException;
import com.vlm.rentals.model.Rentals;
import com.vlm.rentals.repository.RentalsRepository;


@RestController
@RequestMapping("/api/")
public class RentalsController {
	
	@Autowired
	private RentalsRepository rentalsRepository;
	
	@GetMapping("/rentalss")
	public List<Rentals> getAllRentalss(){
		return rentalsRepository.findAll();
	}
	
	@PostMapping("/rentalss")
	public Rentals createParking(@RequestBody Rentals rentals) {
		return rentalsRepository.save(rentals);
	}

	@GetMapping("/rentalss/{id}")
	public ResponseEntity<Rentals> getRentalsById(@PathVariable Long id){
		Rentals rentals = rentalsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Rentals not exist with id :" + id));
		return ResponseEntity.ok(rentals);
	}
	
	@PutMapping("/rentalss/{id}")
	public ResponseEntity<Rentals> updateRentals(@PathVariable Long id, @RequestBody Rentals rentalsDetails){
		Rentals rentals = rentalsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Rentals not exist with id :" + id));
		
		rentals.setName(rentalsDetails.getName());
		rentals.setEmail(rentalsDetails.getEmail());
		rentals.setContact(rentalsDetails.getContact());
		rentals.setLicence_no(rentalsDetails.getLicence_no());
		rentals.setPickup_date(rentalsDetails.getPickup_date());
		rentals.setReturn_date(rentalsDetails.getReturn_date());
		rentals.setCar_no(rentalsDetails.getCar_no());
		rentals.setAmount(rentalsDetails.getAmount());
		
		Rentals updatedRentals = rentalsRepository.save(rentals);
		return ResponseEntity.ok(updatedRentals);
	}
	
	@DeleteMapping("/rentalss/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRentals(@PathVariable Long id){
		Rentals rentals = rentalsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Rentals not exist with id :" + id));
		
		rentalsRepository.delete(rentals);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
