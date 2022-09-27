package com.saraya.airlineservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.airlineservice.model.Airline;
import com.saraya.airlineservice.repository.AirlineRepo;

@Service
public class AirlineService {
	@Autowired
	private final AirlineRepo repo;

	public AirlineService(AirlineRepo repo) {
		
		this.repo = repo;
	}
	public List<Airline>getAll(){
		return repo.findAll();
	}
	
	
	public Airline create(Airline airline) {
		return repo.save(airline);
		
	}
	
	public Airline update(Airline airline) {
		return repo.save(airline);
		
	}
	public void delete(Long id) {
		repo.deleteAll();
	}
	

}
