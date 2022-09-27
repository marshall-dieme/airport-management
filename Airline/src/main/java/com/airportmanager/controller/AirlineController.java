package com.airportmanager.controller;

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

import com.airportmanager.dto.AirlineToAirplaneDto;
import com.airportmanager.dto.AirlineToAirportDto;
import com.airportmanager.exception.ResourceNotFindException;
import com.airportmanager.model.Airline;
import com.airportmanager.repository.AirlineRepository;
import com.airportmanager.services.AirlineService;






@RestController
@RequestMapping("/api/v1")
public class AirlineController {
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private  AirlineService airlineService ;
		
	
	   //get All Airline
		@GetMapping("/airlines")
		public List<Airline> getAllAirline(){
			return airlineRepository.findAll();
		}
	@PostMapping("/airlines")
	public Airline createAirline(@RequestBody Airline airline) {
		return airlineRepository.save(airline);
	}
	//get airline by id rest 
		@GetMapping("/airlines/{id}")
		public ResponseEntity<Airline> getEmployeeById(@PathVariable Long id) {
			Airline airline=airlineRepository.findById(id).orElseThrow(()->new ResourceNotFindException("Airline not exist with id :"+id));
			return ResponseEntity.ok(airline);
		}
		//update Airline rest api
		@PutMapping("/airlines/{id}")
		public ResponseEntity<Airline>updateAirline(@PathVariable Long id,@RequestBody Airline airlineDetails){
			Airline airline = airlineRepository.findById(id).orElseThrow(()->new ResourceNotFindException("Airline not exist with id :"+id));
			airline.setAirline_name(airlineDetails.getAirline_name());
			airline.setIata (airlineDetails.getIata());
			Airline updateAirline=airlineRepository.save(airline);
			return ResponseEntity.ok(updateAirline);
		}
		//delete airline rest api
		
		@DeleteMapping("/airlines/{id}")
		public ResponseEntity <Map<String,Boolean>>deleteAirline(@PathVariable Long id){
			Airline airline=airlineRepository.findById(id).orElseThrow(()->new ResourceNotFindException("Airline  not exist with id :"+id));
			airlineRepository.delete(airline);
			Map<String,Boolean> response= new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
			
			
		}
		//get All AirlineToAirplane
				@GetMapping("/airlineToairplane")
				public List<AirlineToAirplaneDto> getAllAirlineToAirplane(){
					return airlineService.getAllAirlineToAirplaneDto();
				}
				//get All AirlineToAirport
				@GetMapping("/airlineToairport")
				public List<AirlineToAirportDto>getAllAirlineToAirport(){
					return airlineService.getAllAirlineToAirportDto();
				}
		
}
