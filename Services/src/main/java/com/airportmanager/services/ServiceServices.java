package com.airportmanager.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.airportmanager.dto.ServicesToAirportDto;
import com.airportmanager.dto.ServicesToEmployeeDto;
import com.airportmanager.exception.ResourceNotFindException;

import com.airportmanager.model.Services;
import com.airportmanager.repository.ServicesRepository;

@Service
public class ServiceServices {
	@Autowired
	private ServicesRepository serviceRepo;
	
	//create airport_geo
			public Services CreateService(Services service) {
				return serviceRepo.save(service);
				
			}
			//find
			public List<Services>findAllService(){
				return serviceRepo.findAll();	
			}
			//Update airport_geo
			public Services UpdateServices(Services service) {
				return serviceRepo.save(service);	
				
			}
			//find service by id
			public Services findServiceById(Long id) {
				return serviceRepo.findById(id)
				.orElseThrow(()->new ResourceNotFindException("Service by id"+id+"Was not Found"));
			}
		
			//delete airport
			public void DeleteService(Long id) {
				 serviceRepo.deleteById(id);
			}

			//RelationShip Service to Airport
			public List<ServicesToAirportDto>getAllServiceToAirport(){
				return  serviceRepo .findAll()
						.stream()
						.map(this::serviceToairport)
						.collect(Collectors.toList());
			}
			
			private ServicesToAirportDto serviceToairport(Services servic) {
				ServicesToAirportDto SAP = new ServicesToAirportDto();
				 SAP.setServices_name(servic.getServices_name());
				return  SAP;
				
			}
			//RelationShip Service to Employee
			public List<ServicesToEmployeeDto>getAllServiceToEmployee(){
				return  serviceRepo .findAll()
						.stream()
						.map(this::serviceToemployee)
						.collect(Collectors.toList());
			}
			
			private ServicesToEmployeeDto serviceToemployee(Services servic) {
				ServicesToEmployeeDto SE = new ServicesToEmployeeDto();
				 SE.setServices_name(servic.getServices_name());
				return  SE;
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

			
			
			
			
			
			
}
