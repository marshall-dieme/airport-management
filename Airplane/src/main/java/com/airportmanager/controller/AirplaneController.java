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

import com.airportmanager.dto.AirplaneToAirlineDto;
import com.airportmanager.dto.AirplaneToAirplane_Type;
import com.airportmanager.dto.AirplaneToFlightDto;
import com.airportmanager.exception.ResourceNotFindException;
import com.airportmanager.model.Airplane;
import com.airportmanager.repository.AirplaneRepository;
import com.airportmanager.services.AirplaneService;

@RestController

@RequestMapping("/api/airplane")
public class AirplaneController {
	@Autowired
	private AirplaneRepository airplaneRepository;
	@Autowired
	private  AirplaneService airplaneService;
	
	 //get All Airlines
	@GetMapping("/airplane")
	public List<Airplane>getAllAirplane(){
		return airplaneRepository.findAll();
	}
	//create new airplane
	@PostMapping("/airplane")
	public Airplane CreateAirplane(@RequestBody  Airplane airplane) {
		return airplaneRepository.save(airplane);
		
	}
	//get airplane by id rest 
			@GetMapping("/airplane/{id}")
		public	ResponseEntity<Airplane>getAirplaneById(@PathVariable Long id){
				Airplane airplane=airplaneRepository.findById(id).orElseThrow(()->new ResourceNotFindException("Airplane not exist with id :"+id));
				return ResponseEntity.ok(airplane);
			}
	//update Airplane rest api
			@PutMapping("/airplane/{id}")
			public	ResponseEntity<Airplane>UpdateAirplane(@PathVariable Long id,@RequestBody Airplane airplaneDetails){
				Airplane airplane = airplaneRepository.findById(id).orElseThrow(()->new ResourceNotFindException("Airplane not exist with id :"+id));
				airplane.setCapacity(airplaneDetails.getCapacity());
				Airplane UpdateAirplane=airplaneRepository.save(airplane);
				return ResponseEntity.ok( UpdateAirplane);
				
			}
			//delete airplane rest api
			
			@DeleteMapping("/airplane/{id}")
			public ResponseEntity <Map<String,Boolean>>DeleteAirplane(@PathVariable Long id){
				Airplane airplane = airplaneRepository.findById(id).orElseThrow(()->new ResourceNotFindException("Airplane not exist with id :"+id));
				airplaneRepository.delete(airplane);
				Map<String,Boolean> response= new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}
			//get All AirplaneToAirline
			@GetMapping("/airplaneToairline")
			 public List<AirplaneToAirlineDto>getAllAirplaneToAirlineDto(){
				return airplaneService.getAllAirplaneToAirlineDto();
			}
			
			//get All AirplaneToAirplane_Type
			@GetMapping("/airplaneToairplane_type")
			 public List<AirplaneToAirplane_Type>getAirplaneToAirplane_Type(){
				return airplaneService.getAirplaneToAirplane_Type();
			}
			 
			//get All AirplaneToFlight
				@GetMapping("/airplaneToflight")
				 public List<AirplaneToFlightDto>getAllAirplaneToFlightDto(){
					return airplaneService.getAllAirplaneToFlightDto();
				}
			

}
