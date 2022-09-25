package com.saraya.passengerdetails.controller;

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

import com.saraya.passengerdetails.dto.PassengerDetailsDTo;
import com.saraya.passengerdetails.services.PassengerDetailsServices;

@RestController
@RequestMapping("/passengerdetails")
public class PassengerDetailsController {
	@Autowired
	private PassengerDetailsServices detailsServices;
	@PostMapping("/create")
	public PassengerDetailsDTo create(@RequestBody PassengerDetailsDTo detailsDTo) {
		return detailsServices.createPassnegerDetailsDTO(detailsDTo);
	}
	
	@GetMapping("/")
	public List<PassengerDetailsDTo> retrievePassengerDetails() {
		return detailsServices.getAllPassengerDetails();
	}
	
	@GetMapping("/{id}")
	public PassengerDetailsDTo create(@PathVariable Long id) {
		return detailsServices.getPassengerDetails(id);
	}
	
	@PutMapping("/update/{id}")
	public PassengerDetailsDTo update(@RequestBody PassengerDetailsDTo detailsDTo, @PathVariable Long id) {
		return detailsServices.updatePassengerDelais(detailsDTo, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		detailsServices.deletePassengerDetails(id);
	}
}
