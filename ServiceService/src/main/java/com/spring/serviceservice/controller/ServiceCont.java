package com.spring.serviceservice.controller;


import com.spring.serviceservice.DTO.ServicesDto;
import com.spring.serviceservice.bean.Services;
import com.spring.serviceservice.service.ServicesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServiceCont {
    @Autowired
    private ServicesServices service;

    @GetMapping
    public List<Services> getAll(){
       return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Services> getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    public Services create(@RequestBody ServicesDto dto){
        return service.create(dto);
    }

    @PutMapping
    public Services update(@RequestBody Services services){
        return service.update(services);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @GetMapping("/{airportName}/airports")
    List<Services> getServicebyAirport(@PathVariable String airportName){
        return service.getServicebyAirport(airportName);
    }

    @GetMapping("/{name}/name")
    public String getServiceId(@PathVariable String name){
        return service.getServiceId(name);
    }

}
