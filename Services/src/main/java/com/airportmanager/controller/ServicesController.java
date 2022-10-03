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
import com.airportmanager.dto.ServicesToAirportDto;
import com.airportmanager.dto.ServicesToEmployeeDto;
import com.airportmanager.model.Services;
import com.airportmanager.services.ServiceServices;

@RestController
@RequestMapping("/services")
public class ServicesController {
	@Autowired
	private ServiceServices services;
	
	@GetMapping("/allServices")
	public ResponseEntity<List<Services>>getAllServices(){
		List<Services>service=services.findAllService();
		return new ResponseEntity<>(service,HttpStatus.OK);
		
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Services>getServiceById(@PathVariable("id") Long id){
		Services service=services.findServiceById(id);
		return new ResponseEntity<>(service,HttpStatus.OK);
		
	}
	//create
			@PostMapping("/Create")
	public ResponseEntity<Services>CreateService(@RequestBody Services service){
				Services newService=services.CreateService(service);
				return new ResponseEntity<>( newService,HttpStatus.CREATED);
			}
			
			@PutMapping("/Update")
			public ResponseEntity<Services >UpdateServices (@RequestBody Services  service ){
				Services  UpdateServices =services.UpdateServices (service);
				return new ResponseEntity<>(UpdateServices ,HttpStatus.OK);
			}
			
			@DeleteMapping("/Delete{id}")
			public ResponseEntity<Services>DeleteServices(@PathVariable("id") Long id){
				services.DeleteService(id);
				return new ResponseEntity<>(HttpStatus.OK);
				
			}
//			
			
			//get All ServiceToAirport
			@GetMapping("/serviceToairport")
			public List<ServicesToAirportDto> getAllServiceToAirport(){
				return services.getAllServiceToAirport();
		    }
		//	
//			//get All Services To Employee
			@GetMapping("/serviceToemployee")
		  public List<ServicesToEmployeeDto>getAllServiceToEmployee(){
				return services.getAllServiceToEmployee();
			}
			
			
			
			
			
			
	
	
	
	
	
	
	
	
}
