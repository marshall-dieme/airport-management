package com.microservices.airplane.Airlineservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.airplane.Airlineservice.entity.Airline;
import com.microservices.airplane.Airlineservice.entity.AirlineDto;
import com.microservices.airplane.Airlineservice.repository.AirlineRepository;




@Service
public class AirlineService {

	private final AirlineRepository repo;

	public AirlineService(AirlineRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	
	public List<Airline> getAirline(){
		return repo.findAll();
	}
	
	
	public Optional<Airline> getByIdAirline(String id){
		return repo.findById(id);
	}
	
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	
	public Airline create(AirlineDto dto) {
		 Airline airline = new Airline();
	        RestTemplate template = new RestTemplate();
	        Map<String, String> urlValues = new HashMap<>();
	        urlValues.put("airportname", dto.getAirportname());
	        String idAir = template.getForEntity(
	                "http://localhost:8500/airports/name/{airportname}",
	                        String.class,
	                        urlValues)
	                        .getBody();
	        changeToModel(dto, airline);
	        airline.setIdAir(idAir);
	        
	        airline.generateId();
	        return repo.save(airline);
	}


	public List<Airline> getByAirports(String airportname) {
        Map<String, String> values = new HashMap<>();
        values.put("airportname", airportname);
        RestTemplate template = new RestTemplate();
        String idAirport = template.getForEntity("http://localhost:8500/airports/name/{airportname}",
                String.class, values).getBody();

        return repo.findByIdAir(idAirport);
    }
	
	
	
	
	

	private void changeToModel(AirlineDto dto, Airline airline) {
		airline.setAirlinename(dto.getAirlinename());
		airline.setIata(dto.getIata());
		
	}
	
	
	public Airline update(AirlineDto dto) {
		Airline airline = new Airline();
		airline.setId(dto.getId());
		changeToModel(dto, airline);
		return repo.save(airline);
	} 
	
	
	public String getIdAirline(String airlinename) {
		return repo.findByAirlinename(airlinename).getId();
	}
	
}
