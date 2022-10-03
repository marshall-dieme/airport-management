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
import com.airportmanager.model.Airplane_Type;
import com.airportmanager.services.Airport_TypeServices;

@RestController
@RequestMapping("/api/airplanetype")
public class Airplane_TypeController {
	
	@Autowired
	private  Airport_TypeServices airplanetypeService;
	
	//getAll services
	@GetMapping("/allAirplaneTypes")
	public ResponseEntity<List<Airplane_Type>>getAllAirplaneType(){
		List<Airplane_Type>airplanetyp=airplanetypeService.findAllAirplaneType();
		return new ResponseEntity<>(airplanetyp,HttpStatus.OK);
	}
	//find by id
	@GetMapping("/find/{id}")
	public ResponseEntity<Airplane_Type>getfindById(@PathVariable("id") Long id){
		Airplane_Type airplanetyp=airplanetypeService.findAirplaneTypeById(id);
		return new ResponseEntity<>(airplanetyp,HttpStatus.OK);
	}
	//create
	@PostMapping("/Create")
public ResponseEntity<Airplane_Type>CreateAirplaneType(@RequestBody  Airplane_Type airplanetyp ){
	Airplane_Type newAirplane=airplanetypeService.CreateAirplane_Type(airplanetyp);
	return new ResponseEntity<>( newAirplane,HttpStatus.CREATED);
}
@PutMapping("/Update")
public ResponseEntity<Airplane_Type >UpdateAirplane_Type (@RequestBody Airplane_Type airplanetyp ){
	Airplane_Type UpdateAirplane_Type =airplanetypeService.UpdateAirplane_Type (airplanetyp);
	return new ResponseEntity<>(UpdateAirplane_Type ,HttpStatus.OK);
}

@DeleteMapping("/Delete{id}")
public ResponseEntity<Airplane_Type>DeleteServices(@PathVariable("id") Long id){
	airplanetypeService.DeleteAirplane_Type(id);
	return new ResponseEntity<>(HttpStatus.OK);
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
