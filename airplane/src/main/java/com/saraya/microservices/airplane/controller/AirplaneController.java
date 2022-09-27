package com.saraya.microservices.airplane.controller;

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

import com.saraya.microservices.airplane.model.Airplane;
import com.saraya.microservices.airplane.model.AirplaneDTO;
import com.saraya.microservices.airplane.service.AirplaneService;

@RestController
@RequestMapping(value = "/airplane")
public class AirplaneController {

	@Autowired
	private final AirplaneService airplaneService;
	
	public AirplaneController(AirplaneService airplaneService) {
		this.airplaneService = airplaneService;
	}

	@GetMapping
	public List<Airplane> listAirplane() {
		return airplaneService.getAllAirplane();
	}
	
	@PostMapping
	public Airplane create(@RequestBody AirplaneDTO dto) {	 
	    return	airplaneService.addAirplane(dto);
	}
	
	@PutMapping
	public  Airplane update(@RequestBody AirplaneDTO dto) {
		return airplaneService.updateAirplane(dto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		airplaneService.deleteAirplane(id);
	}
	
//	@GetMapping("name/{name}")
//	public Airplane getDepartmentByName(@PathVariable long id) {
//		 Optional<Airplane> optional = airplaneService.(id);
//		 Airplane dept = null;
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
