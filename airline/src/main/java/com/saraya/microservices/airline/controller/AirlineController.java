package com.saraya.microservices.airline.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.microservices.airline.model.Airline;
import com.saraya.microservices.airline.model.AirlineDTO;
import com.saraya.microservices.airline.service.AirlineService;

@RestController
@RequestMapping(value = "/airline")
public class AirlineController {

	@Autowired
	private final AirlineService airlineService;
	
	public AirlineController(AirlineService airlineService) {
		this.airlineService = airlineService;
	}

	@GetMapping
	public List<Airline> listAirline() {
		return airlineService.getAllAirline();
	}
	
	@PostMapping
	public Airline create(@RequestBody AirlineDTO dto) {	 
	    return	airlineService.addAirline(dto);
	}
	
	@PutMapping
	public  Airline update(@RequestBody AirlineDTO dto) {
		return airlineService.updateAirline(dto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		airlineService.deleteAirline(id);
	}
	
//	@GetMapping("name/{name}")
//	public Airline getDepartmentByName(@PathVariable long id) {
//		 Optional<Airline> optional = AirlineService.(id);
//		 Airline dept = null;
//		 if (optional.isPresent()) {
//			dept = optional.get();
//		}else {
//			throw new RuntimeException("This Department`s name doesn`t exist :"+id);
//		}
//		return dept;
//	}
	
//	public List<Department> getByDept(long idDep){
//		Map<String, Long> values = new HashMap<>();
//		values.put("nameOfId", idDep);
//		RestTemplate template = new RestTemplate();
//		String idDept = template.getForEntity("http://localhost:8700/name/{nameOfId}",
//				String.class, values).getBody();
//		return DeptService.findByIdDept(idDept);
//	}
}
