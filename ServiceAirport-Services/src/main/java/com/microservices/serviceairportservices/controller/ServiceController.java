package com.microservices.serviceairportservices.controller;

import com.microservices.serviceairportservices.entity.Services;
import com.microservices.serviceairportservices.entity.ServiceDTO;
import com.microservices.serviceairportservices.service.ServicesService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServicesService service;

    public ServiceController(ServicesService service) {
        this.service = service;
    }
    @GetMapping
    public List<Services> getAll(){
        return service.getAll();
    }

    @GetMapping("/{servicesId}")
    public Optional<Services> getById(@PathVariable Long servicesId) {
        return service.getById(servicesId);
    }

    @PostMapping("/create")
    public Services create(@RequestBody ServiceDTO dto) {
        return service.create(dto);
    }

    @PutMapping
    public Services update(@RequestBody ServiceDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{servicesId}")
    public void delete(@PathVariable Long servicesId) {
        service.delete(servicesId);
    }

    @GetMapping("/{airportName}/serviceairport")
    public List<Services> findAirportByService(@PathVariable String airportName){
        return service.findAirportByService(airportName);
    }

    @GetMapping("/name/{name}")
    public String getIdServ(@PathVariable String servicesName) {
        return service.getIdServ(servicesName);
    }



}

