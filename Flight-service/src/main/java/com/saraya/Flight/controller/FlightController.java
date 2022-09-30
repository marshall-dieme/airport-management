package com.saraya.Flight.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saraya.Flight.model.Flight;
import com.saraya.Flight.model.FlightDto;
import com.saraya.Flight.service.FlightService;

@RestController
@RequestMapping("/flight")
@CrossOrigin("*")//Pour qu'il comminuque avec toutes les methodes
public class FlightController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	public final FlightService service ;

	public FlightController(FlightService service) {
		this.service = service;
	}
	
	//@CrossOrigin("*") uniquement avec le getMapping
	
    @GetMapping
	public List<Flight> getAll(){
        return service.getAll();
        }
    @GetMapping("/{flightNo}")
    public Flight getByFlightNo(@PathVariable String flightNo){
        return service.getByFlightNo(flightNo);
    }
	
    @PostMapping
    public Flight create(@RequestBody FlightDto flight){
    	LOGGER.info("*********CREATING NEW FLIGHT*****");
        return service.create(flight);
    }
    
    @PutMapping
    public Flight update(@RequestBody Flight flight){
        return service.update(flight);
    }
    
    @DeleteMapping("delete/{flightId}")
    public void deleteById(@PathVariable int flightId){
        service.deleteById(flightId);
    }

    @DeleteMapping("/{flightNo}")
    public void deleteByFlightNo(@PathVariable String flightNo){
        service.deleteByFlightNo(flightNo);
    }

    @GetMapping("/flightId/{flightId}")
    public Flight findById(@PathVariable int flightId) {
        return  service.findById(flightId);
    }


}
