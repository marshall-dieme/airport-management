package com.vlm.parking.controller;

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

import com.vlm.parking.exception.ResourceNotFoundException;
import com.vlm.parking.model.Parking;
import com.vlm.parking.repository.ParkingRepository;


@RestController
@RequestMapping("/api/")
public class ParkingController {
	
	@Autowired
	private ParkingRepository parkingRepository;
	
	@GetMapping("/parkings")
	public List<Parking> getAllParkings(){
		return parkingRepository.findAll();
	}
	
	@PostMapping("/parkings")
	public Parking createParking(@RequestBody Parking parking) {
		return parkingRepository.save(parking);
	}
	
	@GetMapping("/parkings/{id}")
	public ResponseEntity<Parking> getParkingById(@PathVariable Long id){
		Parking parking = parkingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Parking not exist with id :" + id));
		return ResponseEntity.ok(parking);
	}
	
	@PutMapping("/parkings/{id}")
	public ResponseEntity<Parking> updateParking(@PathVariable Long id, @RequestBody Parking parkingDetails){
		Parking parking = parkingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Parking not exist with id :" + id));
		
		parking.setName(parkingDetails.getName());
		parking.setEmail(parkingDetails.getEmail());
		parking.setContact(parkingDetails.getContact());
		parking.setEntry_date(parkingDetails.getEntry_date());
		parking.setExit_date(parkingDetails.getExit_date());
		parking.setCar_no(parkingDetails.getCar_no());
		parking.setAmount(parkingDetails.getAmount());
		
		Parking updatedParking = parkingRepository.save(parking);
		return ResponseEntity.ok(updatedParking);
	}
	
	@DeleteMapping("/parking/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteParking(@PathVariable Long id){
		Parking parking = parkingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Parking not exist with id :" + id));
		
		parkingRepository.delete(parking);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
