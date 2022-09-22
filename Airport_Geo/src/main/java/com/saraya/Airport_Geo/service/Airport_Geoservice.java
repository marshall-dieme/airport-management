package com.saraya.Airport_Geo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.saraya.Airport_Geo.Model.Airport_GeoModel;
import com.saraya.Airport_Geo.repository.Airport_GeoRepository;

@Service
public class Airport_Geoservice {

private final Airport_GeoRepository repo ;
	
	public Airport_Geoservice(Airport_GeoRepository airport) {
		this.repo = airport;
	}
	
	public List<Airport_GeoModel> getListAirport(){
		   
		   return repo.findAll();
		   
	   }
	
	 public Airport_GeoModel getBId(int id){
		   return repo.findById(id).get();
		   
	   }
	   
	   public Airport_GeoModel  createAirport(Airport_GeoModel airport_geomodel) {
		   return repo.save(airport_geomodel);
	   }
	   
	   public Airport_GeoModel updateAirport(Airport_GeoModel airport_geomodel) {
		   return repo.save(airport_geomodel);
	   }
	   
	   
	   public void delete(int id) {
		   repo.deleteById(id);
	   }
	   
	   
	 public Airport_GeoModel getAirport_Geo(String Country) {
		 return repo.findByCountry(Country);
	 }
	
	
	
}
