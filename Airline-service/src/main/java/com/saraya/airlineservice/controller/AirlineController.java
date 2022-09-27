package com.saraya.airlineservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.airlineservice.model.Airline;
import com.saraya.airlineservice.service.AirlineService;

@RestController
public class AirlineController {
	@Autowired
private final AirlineService service;

public AirlineController(AirlineService service) {
	
	this.service = service;
}

     @GetMapping("/")
     public List<Airline>getAll(){
    	 return service.getAll();
     }
     
     @PostMapping("/")
     public Airline Create(@RequestBody Airline airline) {
    	 return service.create(airline);
     }
     
     @PutMapping("/")
     public Airline update(@RequestBody Airline airline) {
    	 return service.create(airline);
     }
     @DeleteMapping("/")
     public void delete() {
    	  service.delete(null);
     }

}
