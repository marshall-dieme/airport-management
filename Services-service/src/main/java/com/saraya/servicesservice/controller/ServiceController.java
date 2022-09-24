package com.saraya.servicesservice.controller;

import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.model.ServicesDTO;
import com.saraya.servicesservice.service.ServicesService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {
	 private final Logger LOGGER = LoggerFactory.getLogger(ServiceController.class);
			 
    public final ServicesService service;

    public ServiceController(ServicesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Services> getAll(){
        return service.getAll();
    }

    @GetMapping("/{servicesName}")
    public Services getByServicesName(
            @PathVariable String servicesName){
        return service.getByServicesName(servicesName);
    }

    @PostMapping
    public Services create(@RequestBody ServicesDTO services){
    	LOGGER.info("*********CREATING NEW Service*****");
        return service.create(services);
    }

    @PutMapping
    public Services update(@RequestBody ServicesDTO services){
        return service.update(services);
    }

    @DeleteMapping("delete/{servicesName}")
    public void deleteByServicesName(
            @PathVariable String servicesName){
        service.deleteByServicesName(servicesName);
    }

    @DeleteMapping("/{serviceId}")
    public void deleteById(@PathVariable int serviceId){
        service.deleteById(serviceId);
    }

}
