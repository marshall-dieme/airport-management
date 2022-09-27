package com.saraya.Servicesservice.controller;

import com.saraya.Servicesservice.model.Services;
import com.saraya.Servicesservice.service.ServicesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("services")
public class ServiceRestController {
    private final ServicesService service;

    @GetMapping
    public ResponseEntity<List<Services>> getAllServices() {
        return ResponseEntity.ok(service.getAllServices());
    }

    @GetMapping("/{service_id}")
    public ResponseEntity<Services> getService(@PathVariable Long service_id) {
        return ResponseEntity.ok(service.getServices(service_id));
    }

    @PostMapping
    public ResponseEntity<Services> saveService(@RequestBody Services services) {
        return new ResponseEntity<>(service.saveService(services), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Services> updateService(@RequestBody Services services) {
        return ResponseEntity.ok(service.updateService(services));
    }

    @DeleteMapping("/{service_id}")
    public ResponseEntity<String> deleteService(@PathVariable Long service_id) {
        service.deleteService(service_id);
        return ResponseEntity.ok("Service "+service_id+" was deleted Successfully");
    }

    @GetMapping("/service-name/{service_name}")
    public ResponseEntity<Services> getServiceByName(@PathVariable String service_name) {
        return ResponseEntity.ok(service.getServicesByName(service_name));
    }
}
