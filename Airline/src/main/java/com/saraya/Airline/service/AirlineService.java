package com.saraya.Airline.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.saraya.Airline.model.Airline;
import com.saraya.Airline.model.AirlineDto;
import com.saraya.Airline.repository.AirlineRepository;


@Service
@Transactional
public class AirlineService {
	
	private final AirlineRepository repo;

	
	  public  AirlineService (AirlineRepository repo) { 
		  this.repo = repo; 
		  }
	 
	  public List<Airline> getAll(){
	        return repo.findAll();
	    }

	    public  Airline getByAirline_name(String airline_name){
	        return repo.findByAirline_name(airline_name);
	    }

	    public Airline create (AirlineDto dto){
	    	Airline airline = new Airline();
	        RestTemplate template = new RestTemplate();
	            Map<String , Integer> UrlValues = new HashMap<>();
	        UrlValues.put(("iata"), dto.getAirport_id());
	        Integer airport_id = template.getForEntity(
	                "http://localhost:8200/airport/{iata}",
	                Integer.class, UrlValues)
	                .getBody();
	        changeToModel(dto, airline);
	        airline.setAirport_id(dto.getAirport_id());
	        return repo.save(airline);
	    }

	    public Airline update(AirlineDto dto){
	    	Airline airline = new Airline();
	    	airline.setAirport_id(dto.getAirport_id());
	        changeToModel(dto , airline);
	        return repo.save(airline);
	    }

	    public static void changeToModel(AirlineDto dto , Airline airline){
	    	airline.setAirline_name(dto.getAirline_name());
	    	airline.setIata(dto.getIata());
	    	airline.setAirport_id(dto.getAirport_id());
	    	airline.setAirplane_type_id(dto.getAirplane_type_id());
	    }

		
}
