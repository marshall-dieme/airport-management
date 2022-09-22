package com.saraya.servicesservice.controller;

import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.service.ServiceServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
public class ServicesController {
    private final ServiceServices service;

    public ServicesController(ServiceServices service) {
        this.service = service;
    }

    @GetMapping
    public List<Services> getAll() {
        return service.getAll();
    }

    @GetMapping("/{services_id}")
    public Services getById(@PathVariable Long services_id) {
        return service.getById(services_id);
    }

    @PostMapping
    public Services create(@RequestBody Services s) {
        return service.create(s);
    }

    @PutMapping
    public Services update(@RequestBody Services s) {
        return service.update(s);
    }

//    @DeleteMapping("delete/{services_id}")
//    public void deleteByName(@PathVariable Long services_id) {
//        service.deleteByName(services_id);
//    }

    @DeleteMapping("/{services_id}")
    public void delete(@PathVariable Long services_id) {
        service.delete(services_id);
    }


    @GetMapping("/services_name/{services_name}")
    public Long getIdService(@PathVariable String services_name) {
        return service.getIdService(services_name);
    }
}
