package com.microservice.airplane.Airport_GEO.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.microservice.airplane.Airport_GEO.Enitity.Airport_Geo;
import com.microservice.airplane.Airport_GEO.repository.Airport_Geo_Repo;



@Service
public class Airport_Geo_service {
	
	
	private final Airport_Geo_Repo repo ; 
	
	public Airport_Geo_service(Airport_Geo_Repo repo) {
		
		this.repo=repo;
	}
	
	public List<Airport_Geo> getAll(){
		
		return repo.findAll();
	}
	
	public Optional<Airport_Geo> getById(Long airport_geo_id) {
		return repo.findById(airport_geo_id);
		
	}
	
	public Airport_Geo create(Airport_Geo aGeo) {
		return repo.save(aGeo);
	}

	public Airport_Geo update(Airport_Geo aGeo) {
		return repo.save(aGeo);
	}
	
	public void delete(Long airport_geo_id) {
        repo.deleteById(airport_geo_id);
    }

	public String getIdGeo(String country, String city) {
        return repo.getById(country, city);
    }
	
	

}
