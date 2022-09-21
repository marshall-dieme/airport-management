package com.microservices.serviceairportservices.controller;

import com.microservices.serviceairportservices.entity.Service;
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
    public List<Service> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Service> getById(@PathVariable String servicesId) {
        return service.getById(servicesId);
    }

    @PostMapping
    public Service create(@RequestBody Service serv) {
        return service.create(serv);
    }

    @PutMapping
    public Service update(@RequestBody Service serv) {
        return service.update(serv);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String servicesId) {
        service.delete(servicesId);
    }

    @GetMapping("/servicesName/{servicesName}")
    public String getidServices(@PathVariable String servicesName) {
        return service.getidServices(servicesName);
    }
}

