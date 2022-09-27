package com.saraya.microservices.airport.controller;

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

import com.saraya.microservices.airport.model.Airport;
import com.saraya.microservices.airport.model.AirportDTO;
import com.saraya.microservices.airport.service.AirportService;

@RestController
@RequestMapping(value = "/aiport")
//@RequestMapping("/aiport")
public class AirportController {

	@Autowired
	private final AirportService airportService;
	
	public AirportController(AirportService airportService) {
		this.airportService = airportService;
	}

	@GetMapping
	public List<Airport> listAirport() {
		return airportService.getAllAirport();
	}
	
	@PostMapping
	public Airport create(@RequestBody AirportDTO dto) {	 
	    return	airportService.addAirport(dto);
	}
	
	@PutMapping
	public  Airport update(@RequestBody Airport aip) {
		return airportService.updateAirport(aip);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		airportService.deleteAirport(id);
	}
	
//	@GetMapping("name/{name}")
//	public Airport getDepartmentByName(@PathVariable long id) {
//		 Optional<Airport> optional = airportService.(id);
//		 Airport dept = null;
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
