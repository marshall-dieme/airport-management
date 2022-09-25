package com.microservices.airplane.AirportsServices.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.airplane.AirportsServices.entity.AirportDto;
import com.microservices.airplane.AirportsServices.entity.Airports;
import com.microservices.airplane.AirportsServices.repository.AirportsRepository;

@Service
public class AirportsService {

	
	private final AirportsRepository repo;

	public AirportsService(AirportsRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public List<Airports> getAll(){
		return repo.findAll();
	}
	
	
	public Airports getById(String airport_id) {
		return repo.findById(airport_id).get();
	}
	
	
	public Airports create(AirportDto dto) {
		
		Airports airports = new Airports();
		RestTemplate resttemplate = new RestTemplate();
		Map<String, String> urlValues = new HashMap<>();
		urlValues.put("country", dto.getCountry());
		urlValues.put("city", dto.getCity());
		
		String idAirportGeo = resttemplate.getForEntity( "http://localhost:8700/airportGeo/country/city/{country}/{city}",
				String.class, urlValues).getBody();
		
		changeToModel(dto, airports);
		airports.setIdAirportGeo(idAirportGeo);
		
		
		airports.generateId();
		return repo.save(airports);
	}


	private void changeToModel(AirportDto dto, Airports airports) {
		// TODO Auto-generated method stub
		airports.setAirport_name(dto.getAirport_name());
		airports.setIata(dto.getIata());
		airports.setIcao(dto.getIcao());
		
		
	}

	
	//OneToOne
	public Airports findAirportByAirportGeo(String country, String city) {
		RestTemplate template = new RestTemplate();
		Map<String, String> urlValues = new HashMap<>();
		urlValues.put("country", country);
		urlValues.put("city", city);
		String idAirportGeo = template.getForEntity("http://localhost:8700/airportGeo/country/city/{country}/{city}",
				 String.class,
				 urlValues)
				.getBody();
		return repo.findByIdAirportGeo(idAirportGeo);
	}
	
	

	public Airports update(AirportDto dto) {
		Airports air = new Airports();
		air.setAirport_id(dto.getAirport_id());
		changeToModel(dto, air);
		return repo.save(air);
	}

	public void delete(String airport_id) {
		repo.deleteById(airport_id);
	}
	
	
	
	public String getIdAirport(String airportname) {
		return repo.findByAirportname(airportname).getAirport_id();
	}

	
	
	
	
	
	
	
	
}
