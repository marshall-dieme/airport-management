package com.saraya.services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saraya.services.model.Services;
import com.saraya.services.model.ServicesDTO;

@Service
public interface Servicesservice {
	
	List<ServicesDTO> getAll();
	
	ServicesDTO getById(Long id);
	
	Services create(ServicesDTO dto);
	
	List<Services> getServicesByAirport(String airportName);
	
	ServicesDTO update(ServicesDTO dto, Long id);
	
	void delete(Long id);

}
