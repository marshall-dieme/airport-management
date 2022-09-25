package com.microservices.airline.Passager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.microservices.airline.Passager.entity.Passager;
import com.microservices.airline.Passager.repository.PassagerRepository;

@Service
public class PassagerService {
	
	
	private final PassagerRepository repo;

	public PassagerService(PassagerRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public List<Passager> getPassager(){
		return repo.findAll();
	}
	
	
	public Optional<Passager> getByid(String passagerid){
		return repo.findById(passagerid);
		
	}
	
	public Passager create(Passager passager) {
		passager.generateId();
		return repo.save(passager);
	}
	
	
	
	public Passager update(Passager passager) {
		return repo.save(passager);
	}
	
	
	
	public void delete(String passagerid) {
		repo.deleteById(passagerid);
	}
	
	
	public String getByPassportno(String passportno) {
		return repo.findByPassportno(passportno).getPassagerid();
	}
	
	
	
	

}
