package com.airplane.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airplane.dao.Airplane_Repository;
import com.airplane.entities.Airplane;

@Service
public class Airplane_Service {
	
	@Autowired
	private Airplane_Repository airplane_Repository;
	
	public List<Airplane> getAll(){
		return airplane_Repository.findAll();
	}
	public Airplane getById(long id) {
		return airplane_Repository.getById(id);
	}
	public Airplane create(Airplane airplane) {
		return airplane_Repository.save(airplane);
	}
	public Airplane update(Airplane airplane) {
		return airplane_Repository.save(airplane);
	}
	public void delete(long id) {
		airplane_Repository.deleteById(id);
	}
}
