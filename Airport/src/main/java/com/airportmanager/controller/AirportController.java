package com.airportmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.airportmanager.model.Airport;
import com.airportmanager.services.AirportServices;

@RestController
@RequestMapping("/airport")
public class AirportController {
	
	@Autowired
	private  AirportServices airportServices;
	
	@GetMapping("/allAirports")
	public ResponseEntity<List<Airport>> getAllAirports(){
		List<Airport>airport=airportServices.findAllAirports();
		return new ResponseEntity<>(airport ,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Airport>getAirportById(@PathVariable("id") Long id){
		Airport airport= airportServices.findAirportById(id);
		return new ResponseEntity<>(airport,HttpStatus.OK);
		
	}
	//create
	@PostMapping("/Create")
	public ResponseEntity<Airport> CreateAirport(@RequestBody Airport airport){
		Airport newAirport = airportServices.CreateAirport(airport);
		return new ResponseEntity<>(newAirport ,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/Update")
	public ResponseEntity<Airport> UpdateAirport(@RequestBody Airport airport){
		Airport UpdateAirport = airportServices.UpdateAirport(airport);
		return new ResponseEntity<>(UpdateAirport ,HttpStatus.OK);
		
	}
	@DeleteMapping("/Delete{id}")
	public ResponseEntity<Airport> deleteAirport(@PathVariable("id") Long id){
		airportServices.deleteAirport(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
//	//get All AirlineToAirplane
//	
//	@GetMapping("/airportToairline")
//		public List<AirportToAirlineDto> getAllAirportToAirline(){
//			return airportServices.getAllAirportToAirlineDto();
//		}
//	
//	//get All AirlineToAirport_Geo
//	@GetMapping("/airportToairline")
//	public List<AirportToAirport_Geo>getAllAirportToairport_Geo(){
//		return airportServices.getAllAirportToAirport_Geo();
//    }
//	
//	//get All AirlineToServices
//	@GetMapping("/airportToservices")
//	public List<AirportToServices>getAllAirportToservices(){
//		return airportServices.getAllAirportToServices();
//	}
//	
//	
	
}
