package com.saraya.Airplaneservice.controller;

import com.saraya.Airplaneservice.model.Airplane;
import com.saraya.Airplaneservice.service.AirplaneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("airplanes")
@RestController
public class AirplaneRestController {

    private final AirplaneService service;

    @GetMapping
    public ResponseEntity<List<Airplane>> getAllAirplanes() {
        return ResponseEntity.ok(service.getAllAirplanes());
    }

    @GetMapping("/{airplane_id}")
    public Airplane getAirplane(@PathVariable Long airplane_id) {
        return service.getAirplane(airplane_id);
    }

    @PostMapping
    public ResponseEntity<Airplane> saveAirplane(@RequestBody Airplane airplane) {
        return new ResponseEntity<>(service.saveAirplane(airplane), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Airplane> updateAirplane(@RequestBody Airplane airplane) {
        return ResponseEntity.ok(service.updateAirplane(airplane));
    }

    public ResponseEntity<String> deleteAirplane(@PathVariable Long airplane_id) {
        service.deleteAirplane(airplane_id);
        return ResponseEntity.ok("Airplane "+airplane_id+" was deleted successfully");
    }

}
