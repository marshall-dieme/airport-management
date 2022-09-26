package com.vlm.airline.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vlm.airline.model.Airline;
import com.vlm.airline.model.AirlineDTO;
import com.vlm.airline.repository.AirlineRepository;

@Service
public class AirlineService {
	
	private final AirlineRepository repo;

    public AirlineService(AirlineRepository repo) {
        this.repo = repo;
    }

    public List<Airline> getAll() {
        return repo.findAll();
    }
    
    public Optional<Airline> getById(Long id) {
        return repo.findById(id);
    }
    
    public Airline create(AirlineDTO dto) {
    	Airline airline = new Airline();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("airlines", dto.getIata());
        String Iata = template.getForEntity(
                "http://localhost:8700/iata/airlines/{airlines}",
                        String.class,
                        urlValues)
                        .getBody();
        changeToModel(dto, airline);
        airline.setIata(Iata);
        return repo.save(airline);
    }
    private void changeToModel(AirlineDTO dto, Airline airline) {
    	
    	airline.setAirline_name(dto.getAirline_name());
    	airline.setIata(dto.getIata());
    }
	
	public Airline update(AirlineDTO dto) {
		Airline airline = new Airline();
        airline.setIata(dto.getIata());
        changeToModel(dto, airline);
        return repo.save(airline);
    }
	
	public void delete(Long id) {
        repo.deleteById(id);
    }
	
	public List<Airline> getByIata(String iata) {
        Map<String, String> values = new HashMap<>();
        values.put("airlines", iata);
        RestTemplate template = new RestTemplate();
        String Iata = template.getForEntity("http://localhost:8700/iata/airlines/{airlines}",
                String.class, values).getBody();

        return repo.findByIata(Iata);
    }
	
	public Airline createWithRelation(AirlineDTO dto) {
		Airline airline = new Airline();
        changeToModel(dto, airline);
        String Iata = new RestTemplate().getForEntity(
                "http://localhost:8700/airlines/airlines/"+dto.getIata(),
                String.class).getBody();
        airline = repo.save(airline);
        Map<String, String> values = new HashMap<>();
        values.put("Iata", Iata);
        values.put("Iata", String.valueOf(airline.getIata()));
        new RestTemplate().getForEntity("http://localhost:8900/relation/{Iata}/{idAirline}",
                Void.class, values);

        return airline;
    }
	
}
