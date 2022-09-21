package com.saraya.airportgeo.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.saraya.airportgeo.Repository.AirportGeoRepo;
import com.saraya.airportgeo.model.Airport_Geo;
import com.saraya.airportgeo.model.Airport_GeoDto;

@Service
@Transactional
public class AirportGeoService {

	  //injection a partir du controller
    private final AirportGeoRepo repo;

		
		  public AirportGeoService(AirportGeoRepo repo) { 
			  this.repo = repo; 
			  }
		 
		  public List<Airport_Geo> getAll(){
		        return repo.findAll();
		    }

		    public  Airport_Geo getByCountry(String country){
		        return repo.findByCountry(country);
		    }

		    
		    public Airport_Geo create (Airport_GeoDto dto){
		        Airport_Geo airport = new Airport_Geo();
		        RestTemplate template = new RestTemplate();
		            Map<String , Integer> UrlValues = new HashMap<>();
		        UrlValues.put(("iata"), dto.getAirport_geo_id());
		        Integer airport_id = template.getForEntity(
		                "http://localhost:8200/airport/{iata}",
		                Integer.class, UrlValues)
		                .getBody();
		        changeToModel(dto, airport);
		        airport.setAirport_id(dto.getAirport_id());
		        return repo.save(airport);
		    }

		    public Airport_Geo update(Airport_GeoDto dto){
		        Airport_Geo airport = new Airport_Geo();
		        airport.setAirport_geo_id(dto.getAirport_id());
		        changeToModel(dto , airport);
		        return repo.save(airport);
		    }

		    public static void changeToModel(Airport_GeoDto dto , Airport_Geo airport){
		    	airport.setAirport_geo_id(dto.getAirport_geo_id());
		    	airport.setCountry(dto.getCountry());
		        airport.setCity(dto.getCity());
		        airport.setAirport_id(dto.getAirport_id()); 
		    }

		    public void deleteByCountry( String country){
		        Airport_Geo airport_Geo = repo.findByCountry(country);
		        repo.delete(airport_Geo);
		    }
		   
			
}
