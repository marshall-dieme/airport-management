package com.microservices.airplane.ServicesServices.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.airplane.ServicesServices.entity.ServiceDto;
import com.microservices.airplane.ServicesServices.entity.Services;
import com.microservices.airplane.ServicesServices.repository.ServiceRepository;

@Service
public class ServicesService {

	private final ServiceRepository repo;

	public ServicesService(ServiceRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public List<Services> getService(){
		return repo.findAll();
	}
	
	
	public Services getById(int id) {
		return repo.findById(id).get();
		
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	
	public Services create(ServiceDto dto) {
        Services serv = new Services();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("airportname", dto.getAirportname());
        String idAir = template.getForEntity(
                "http://localhost:8500/airports/name/{airportname}",
                        String.class,
                        urlValues)
                        .getBody();
        changeToModel(dto, serv);
        serv.setIdAir(idAir);
        return repo.save(serv);
    }

	public List<Services> getByAirports(String airportname) {
        Map<String, String> values = new HashMap<>();
        values.put("airportname", airportname);
        RestTemplate template = new RestTemplate();
        String idAirport = template.getForEntity("http://localhost:8500/airports/name/{airportname}",
                String.class, values).getBody();

        return repo.findByIdAir(idAirport);
    }


	private void changeToModel(ServiceDto dto, Services serv) {
		serv.setServiceName(dto.getServiceName());
		
	}
	
	
	public Services update(ServiceDto dto) {
		Services ser = new Services();
		ser.setId(dto.getId());
		changeToModel(dto, ser);
		return repo.save(ser);
	} 
	
	
	
	
}
