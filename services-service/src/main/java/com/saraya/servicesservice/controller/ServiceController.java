package com.saraya.servicesservice.controller;

import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.service.ServicesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

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
    public Services create(@RequestBody Services services){
        return service.create(services);
    }

    @PutMapping
    public Services update(@RequestBody Services services){
        return service.update(services);
    }

    @DeleteMapping("delete/{servicesName}")
    public void deleteByServicesName(
            @PathVariable String servicesName){
        service.deleteByServicesName(servicesName);
    }

    @DeleteMapping("/{service_id}")
    public void deleteById(@PathVariable int service_id){
        service.deleteById(service_id);
    }

}
