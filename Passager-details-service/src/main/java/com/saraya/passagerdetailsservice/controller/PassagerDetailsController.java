package com.saraya.passagerdetailsservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saraya.passagerdetailsservice.model.PassagerDetails;
import com.saraya.passagerdetailsservice.model.PassagerDetailsDto;
import com.saraya.passagerdetailsservice.service.PassagerDetailsService;

@RestController
@RequestMapping("/passagerDetails")
public class PassagerDetailsController {
	
	private final PassagerDetailsService service;

	public PassagerDetailsController(PassagerDetailsService service) {
		this.service = service;
	}
	
	 @GetMapping
	    public List<PassagerDetails> getAll(){
	        return service.getAll();
	    }
	 
	 @GetMapping("/{email}")
	    public PassagerDetails getByEmail(
	            @PathVariable String email){
	        return service.getByEmail(email);
	    }

	 @PostMapping
	    public PassagerDetailsDto create(@RequestBody PassagerDetailsDto passagerDetailsDto){
	        return service.create(passagerDetailsDto);
	    }
	 
	 @PutMapping
	    public PassagerDetails update(@RequestBody PassagerDetailsDto passagerDetailsDto){
	        return service.update(passagerDetailsDto);
	    }
	 
	 @DeleteMapping("delete/{passportNo}")
	    public void deleteByPassportNo(
	            @PathVariable String passportNo){
	        service.deleteByPassportNo(passportNo);
	    }
	 
	 @DeleteMapping("/{passengerDetailsId}")
	    public void deleteByPassengerDetailsId(
	            @PathVariable int passengerDetailsId){
	        service.deleteBypassengerDetailsId(passengerDetailsId);
	    }
}
