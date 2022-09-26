package com.saraya.airplane.controller;

import com.saraya.airplane.model.Airplane;
import com.saraya.airplane.service.AirplaneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("airplanes")
@RestController
public class AirplaneControl {
    private final AirplaneService service;


    @GetMapping
    public ResponseEntity<List<Airplane>> getAllAirplanes() {
        return ResponseEntity.ok(service.getAllAirplanes());
    }

    @GetMapping("/{airplane_id}")
    public Airplane getAirplane(@PathVariable Long airplane_id) {
        return service.getAirplane(airplane_id);
    }
    @GetMapping("/{capacity}")
    public Airplane getAirplaneByCapacity(@PathVariable int capacity) {
        return service.getAirplaneByCapacity(capacity);
    }

    @PostMapping
    public ResponseEntity<Airplane> saveAirplane(@RequestBody Airplane airplane) {
        return new ResponseEntity<>(service.saveAirplane(airplane), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Airplane> updateAirplane(@RequestBody Airplane airplane) {
        return ResponseEntity.ok(service.updateAirplane(airplane));
    }

    @DeleteMapping("/{airplane_id}")
    public ResponseEntity<String> deleteAirplane(@PathVariable Long airplane_id) {
        service.deleteAirplane(airplane_id);
        return ResponseEntity.ok("Airplane "+airplane_id+" was deleted successfully");
    }
}
