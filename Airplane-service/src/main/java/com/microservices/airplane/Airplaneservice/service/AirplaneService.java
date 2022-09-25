package com.microservices.airplane.Airplaneservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.microservices.airplane.Airplaneservice.entity.Airplane;
import com.microservices.airplane.Airplaneservice.entity.AirplaneDto;
import com.microservices.airplane.Airplaneservice.repository.AirplaneRepository;



@Service
public class AirplaneService {

	
	private final AirplaneRepository repo;

	public AirplaneService(AirplaneRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public List<Airplane> getAllAirplane(){
		return repo.findAll();
	}
	
	
	public Optional<Airplane> getById(String id){
		return repo.findById(id);
	}
	
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
	
	
	
	public Airplane create(AirplaneDto dto) {
		 Airplane airplane = new Airplane();
	        RestTemplate template = new RestTemplate();
	        Map<String, String> urlValues = new HashMap<>();
	        urlValues.put("airlinename", dto.getAirlinename());
	        String idAirline = template.getForEntity(
	                "http://localhost:8100/airline/name/{airlinename}",
	                        String.class,
	                        urlValues)
	                        .getBody();
	        changeToModel(dto, airplane);
	        airplane.setIdAirline(idAirline);
	        
	        airplane.generateId();
	        return repo.save(airplane);
	}


	private void changeToModel(AirplaneDto dto, Airplane airplane) {
		airplane.setCapacity(dto.getCapacity());
			
	}
	
	
	
	
	public List<Airplane> getByAirline(String airlinename) {
        Map<String, String> values = new HashMap<>();
        values.put("airlinename", airlinename);
        RestTemplate template = new RestTemplate();
        String idAirline = template.getForEntity("http://localhost:8100/airline/name/{airlinename}",
                String.class, values).getBody();

        return repo.findByIdairline(idAirline);
    }
	
	public Airplane update(AirplaneDto dto) {
		Airplane air = new Airplane();
		air.setId(dto.getId());
		changeToModel(dto, air);
		return repo.save(air);
	} 
	
	
	public String getAirplaneByAirlin(String capacity) {
		return repo.findByCapacity(capacity).getId();
	}
	
	
}
