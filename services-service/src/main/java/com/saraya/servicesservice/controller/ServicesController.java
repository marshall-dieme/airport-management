package com.saraya.servicesservice.controller;

import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.service.ServicesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("services")
public class ServicesController {

    private final ServicesService service;

    public ServicesController(ServicesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Services> getAll(){
        return service.getAllServices();
    }
    @GetMapping("/{services_id}")
    public Services getById(@PathVariable Long services_id){

        return service.getByIdServices(services_id);
    }
@PostMapping
    public Services create(@RequestBody Services services){

        return service.createServices(services);
    }

    @PutMapping
    public Services edit(@RequestBody Services services){

        return service.updateServices(services);
    }
    @DeleteMapping("/{services_id}")
    public void delete(@PathVariable Long services_id)
    {
        service.deleteServices(services_id);
    }
    @GetMapping("/services_name/{services_name}")
    public Long getId(@PathVariable String services_name){
        return service.getServicesId(services_name);
    }
}
