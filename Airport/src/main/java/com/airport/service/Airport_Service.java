package com.airport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.entities.Airport;
import com.airport.repository.Airport_Repository;

@Service
public class Airport_Service {
	
	@Autowired
	private Airport_Repository airport_Repository;
	
	public List<Airport> getAll(){
		return airport_Repository.findAll();
	}
	
	public Airport getById(long id) {
		return airport_Repository.getById(id);
	}
	public Airport create(Airport airport) {
		return airport_Repository.save(airport);
	}
	public Airport update(Airport airport) {
		return airport_Repository.save(airport);
	}
	public void delete(long id) {
		airport_Repository.deleteById(id);
	}
	

}
