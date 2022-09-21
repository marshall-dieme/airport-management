package com.saraya.Services.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.Services.model.Services_airport;
import com.saraya.Services.model.Services_airportDto;
import com.saraya.Services.service.ServicesService;



@RestController
@RequestMapping("/service_airport")
public class ServicesController {

	private final ServicesService service ;

    public  ServicesController (ServicesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Services_airport> getAll(){
        return service.getAll();
    }

    @GetMapping("/{services_name}")
    public Services_airport getByServices_name(@PathVariable String services_name){
        return service.getByServices_name(services_name);
    }

    @PostMapping
    public Services_airport create(@RequestBody Services_airportDto services_airportDto){
        return service.create(services_airportDto);
    }

    @PutMapping
    public Services_airport update(@RequestBody Services_airportDto services_airportDto){
        return service.update(services_airportDto);
    }

    @DeleteMapping("delete/{services_name}")
    public void deleteByServices_name(@PathVariable String services_name){
        service.getByServices_name(services_name);
    }

}
