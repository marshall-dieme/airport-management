package com.saraya.service.controller;

import com.saraya.service.model.Services;
import com.saraya.service.service.ServicesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("Services")
public class ServicesControl {
    private final ServicesService service;

    @GetMapping
    public ResponseEntity<List<Services>> getAllServices() {
        return ResponseEntity.ok(service.getAllServices());
    }

    @GetMapping("/{service_id}")
    public ResponseEntity<Services> getServices(@PathVariable Long service_id) {
        return ResponseEntity.ok(service.getServices(service_id));
    }

    @PostMapping
    public ResponseEntity<Services> saveServices(@RequestBody Services services) {
        return new ResponseEntity<>(service.saveServices(services), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Services> updateServices(@RequestBody Services services) {
        return ResponseEntity.ok(service.updateServices(services));
    }


    @DeleteMapping("/{service_name}")
    public ResponseEntity<String> deleteServices(@PathVariable String services_name) {
        return ResponseEntity.ok("Service "+services_name+" was deleted Successfully");
    }

    @GetMapping("/service-name/{name}")
    public ResponseEntity<Services> getServicesByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getServicesByName(name));
    }
}
