package com.microservices.airplane.Services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.airplane.Services.entity.Services;
import com.microservices.airplane.Services.repository.ServiceRepository;




@Service
public class ServiceService {

	private final ServiceRepository repo;

	public ServiceService(ServiceRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public List<Services> ListServices(){
		return repo.findAll();
	}
	
	
	public Services saveService(Services service) {
		service.generateId();
		return repo.save(service);
	}
	
	
	public Services getId(String service_id) {
		return repo.findById(service_id).get();
	}
	
	
	public Services update(Services service) {
		return repo.save(service);
		
	}
	
	
	public void delete(String id) {
		 repo.deleteById(id);
	}
	
	
	
	
	
	
	
}
