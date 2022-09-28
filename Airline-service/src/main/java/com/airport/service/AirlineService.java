package com.airport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.dao.Airline_Repository;
import com.airport.entities.Airline;

@Service
public class AirlineService {
	
	@Autowired 
	private Airline_Repository airline_Repository;
	
	public List<Airline> getAll(){
		return airline_Repository.findAll();
	}
	
	public Airline getById(long id) {
		return airline_Repository.getById(id);
	}
	public Airline create(Airline airline) {
		return airline_Repository.save(airline);
	}
	public Airline update(Airline airline) {
		return airline_Repository.save(airline);

	}
	public void delete(long id) {
		airline_Repository.deleteById(id);
	}
}
