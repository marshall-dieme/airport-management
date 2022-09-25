package com.microservices.airplane.Airlineservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.airplane.Airlineservice.entity.Airline;
import com.microservices.airplane.Airlineservice.entity.AirlineDto;
import com.microservices.airplane.Airlineservice.service.AirlineService;



@RestController
@RequestMapping("/airline")
//@Slf4j pour le debeugage
public class AirlineController {

	private final AirlineService service;

	public AirlineController(AirlineService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	public List<Airline> getAll(){
		return service.getAirline();
		
	}
	
	
	@GetMapping("/{id}")
	public Optional<Airline> getById(@PathVariable String id){
		return service.getByIdAirline(id);
	}
	
	
	@PostMapping
	public Airline create(@RequestBody AirlineDto dto) {
		return service.create(dto);
	}
	
	
	@PutMapping
	public Airline update(@PathVariable AirlineDto dto) {
		return service.update(dto);
	}
	
	
	@DeleteMapping("/{id}") 
	public void delete(@PathVariable String id) {
		service.delete(id);
	}
	
	
	@GetMapping("/{airportname}/airlines")
	 public List<Airline> getAirlineByAirports(@PathVariable String airportname) {
       return service.getByAirports(airportname);
    		   
   }
	
	
	
	@GetMapping("/name/{airlinename}")
	public String getIdAirline(@PathVariable String airlinename) {
		return service.getIdAirline(airlinename);
	}
	
	
	
	
	
	
}
