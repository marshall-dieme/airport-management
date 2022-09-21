package com.saraya.Airport.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saraya.Airport.model.Airport;
import com.saraya.Airport.model.AirportDto;
import com.saraya.Airport.repository.AirportRepository;


@Service
@Transactional
public class AirportService {
	
    private final AirportRepository repo;

	
		  public AirportService(AirportRepository repo) { 
			  this.repo = repo; 
			  }
		 
		  public List<Airport> getAll(){
		        return repo.findAll();
		    }

		    public  Airport getByIata(String iata ){
		        return repo.findByIata(iata);
		    }
		   		    
		    public Airport create (AirportDto dto){
		        Airport airport = new Airport();
		        RestTemplate template = new RestTemplate();
		            Map<String , Integer> UrlValues = new HashMap<>();
		        UrlValues.put(("country"), dto.getAirport_geo_id());
		        Integer airport_geo_id = template.getForEntity(
		                "http://localhost:8100/airportGeo/{country}",
		                Integer.class, UrlValues)
		                .getBody();
		        UrlValues.put(("services_name"), dto.getServices_id());
		        Integer services_id = template.getForEntity(
		                "http://localhost:8300/service_airport/{services_name}",
		                Integer.class, UrlValues)
		                .getBody();
		        changeToModel(dto, airport);
		        airport.setAirport_geo_id(dto.getAirport_geo_id());
		        airport.setServices_id(dto.getServices_id());
		        return repo.save(airport);
		    }

		    public Airport update(AirportDto dto){
		        Airport airport = new Airport();
		        airport.setAirport_id(dto.getAirport_id());
		        changeToModel(dto , airport);
		        return repo.save(airport);
		    }

		    public static void changeToModel(AirportDto dto , Airport airport){
		        airport.setAirport_name(dto.getAirport_name());
		        airport.setIata(dto.getIata());
		        airport.setIcao(dto.getIcao());
		        airport.setAirport_geo_id(dto.getAirport_geo_id());
		        airport.setServices_id(dto.getServices_id());


		    }

			

}
