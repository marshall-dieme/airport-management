package com.saraya.microservices.airportmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.microservices.airportmanagement.model.Airport_Geo;
import com.saraya.microservices.airportmanagement.model.Airport_Geo_DTO;
import com.saraya.microservices.airportmanagement.service.AirGeoService;


@RestController
@RequestMapping(value = "/aiport_geo")
public class AirportGeoController {

	@Autowired
	private final AirGeoService airGeoService;

	public AirportGeoController(AirGeoService airGeoService) {
		this.airGeoService = airGeoService;
	}
	
	@GetMapping
	public List<Airport_Geo> getListAirportGeo(){
		return airGeoService.listAirpGeo();
	}
	
	@PostMapping
	public Airport_Geo createAipGeo(@RequestBody Airport_Geo_DTO dto) {
        return airGeoService.createAirportGeo(dto);
	}
	

    @GetMapping("/name/{name}")
    public String getIdAirport(@PathVariable String name) {
        return airGeoService.getIdAirport(name);
    }
 
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("name/{name}")
//	public Department getDepartmentByName(@PathVariable long id) {
//		 Optional<Department> optional = deptService.getDepartmentById(id);
//		Department dept = null;
//		if (optional.isPresent()) {
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
