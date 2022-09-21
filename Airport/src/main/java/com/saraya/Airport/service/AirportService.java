package com.saraya.Airport.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.Airport.model.AirportModel;
import com.saraya.Airport.repository.AirportRepository;


@Service
public class AirportService {

	
	private final AirportRepository repo;
	
	public AirportService(AirportRepository airport) {
		this.repo = airport;
	}
	
	public List<AirportModel> getListAirport(){
		   
		   return repo.findAll();
		   
	   }
	
	 public Optional<AirportModel> getBId(int id){
		   
		   return repo.findById(id);
		   
	   }
	   
	   public AirportModel  createAirport(AirportModel airport) {
		   return repo.save(airport);
	   }
	   
	   public AirportModel updateAirport(AirportModel airport) {
		   return repo.save(airport);
	   }
	   
	   
	   public void delete(int id) {
		   repo.deleteById(id);
	   }
	   
	   
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
