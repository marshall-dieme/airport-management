package com.saraya.passagerservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saraya.passagerservice.model.Passenger;
import com.saraya.passagerservice.service.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
	
	 private final Logger LOGGER = LoggerFactory.getLogger(PassengerController.class);

	public final PassengerService service ;

	public PassengerController(PassengerService service) {
		this.service = service;
	}
	
    @GetMapping
	public List<Passenger>  getAll(){
        return service.getAll();
        }
		
    @GetMapping("/{passportNo}")
    public Passenger getByPassportNo(@PathVariable String passportNo){
        return service.getByPassportNo(passportNo);
    }
	
    @PostMapping
    public Passenger create(@RequestBody Passenger passenger){
    	LOGGER.info("*********CREATING NEW AIRPORT*****");
        return service.create(passenger);
    }

    @PutMapping
    public Passenger update(@RequestBody Passenger passenger){
        return service.update(passenger);
    }
    
    @DeleteMapping("delete/{passportNo}")
    public void deleteByPassportNo(@PathVariable String passportNo){
        service.deleteByPassportNo(passportNo);
    }

    @DeleteMapping("/{passengerId}")
    public void deleteByPassengerId(@PathVariable int passengerId){
        service.deleteByPassengerId(passengerId);
    }

    @GetMapping("/passportNo/{passportNo}")
    public Integer  findByPassportNo(@PathVariable String passportNo) {
        return  service.findByPassportNo(passportNo).getPassengerId();
    }

}
