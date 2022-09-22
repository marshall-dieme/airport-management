package com.saraya.Services.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.Services.entity.Services;
import com.saraya.Services.repository.ServicesRepo;
import com.saraya.Services.service.ServicesService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/services")
public class ServiceController {

    
    private final ServicesService service;

    private final ServicesRepo repository;

    @GetMapping("/allServices")
    public ResponseEntity<List<Services>> getAllServices() {
        return ResponseEntity.ok(service.getAllServices());
    }

    @GetMapping("/find/{service_id}")
    public ResponseEntity<Services> getService(@PathVariable Long service_id) {
        return ResponseEntity.ok(service.getService(service_id));
    }

   
    @DeleteMapping("/delete/{service_id}")
    public ResponseEntity<String> deleteService(@PathVariable Long service_id) {
        return ResponseEntity.ok("this service "+service_id+" has already deleted");
    }

    @PutMapping("/update/{service_id}")
    public ResponseEntity<Services> updateService( @PathVariable Long service_id, @RequestBody Services service) {

        Services newService = repository.findById(service_id).orElse(new Services());
        newService.setServices_name(newService.getServices_name());

        return new ResponseEntity<Services>(repository.save(service), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addService")
    public ResponseEntity<Services> saveService(@RequestBody Services service) {
        return new ResponseEntity<>(repository.save(service), HttpStatus.CREATED);
    }
}