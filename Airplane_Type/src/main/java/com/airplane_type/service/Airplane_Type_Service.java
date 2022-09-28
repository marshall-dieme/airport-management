package com.airplane_type.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airplane_type.dao.Airplane_Type_Repository;
import com.airplane_type.entities.Airplane_Type;

@Service
public class Airplane_Type_Service {
	
	@Autowired 
	private Airplane_Type_Repository airplane_Type_Repository;
	
	public List<Airplane_Type> getAll(){
		return airplane_Type_Repository.findAll();
	}
	public Airplane_Type getById(long id ) {
		return airplane_Type_Repository.getById(id);
	}
	public Airplane_Type create(Airplane_Type airplane_Type) {
		return airplane_Type_Repository.save(airplane_Type);
	}
	public Airplane_Type update(Airplane_Type airplane_Type) {
		return airplane_Type_Repository.save(airplane_Type);
	}
	public void delete(long id) {
		airplane_Type_Repository.deleteById(id);
	}
}
