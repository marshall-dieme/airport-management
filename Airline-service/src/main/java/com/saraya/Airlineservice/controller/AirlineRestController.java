package com.saraya.Airlineservice.controller;

import com.saraya.Airlineservice.bean.ResponseAirlineWithAirplanes;
import com.saraya.Airlineservice.model.Airline;
import com.saraya.Airlineservice.service.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("airlines")
@RestController
public class AirlineRestController {

    private final AirlineService service;

    @GetMapping
    public ResponseEntity<List<Airline>> getAllAirlines() {
        return ResponseEntity.ok(service.getAllAirlines());
    }

    @GetMapping("/{airline_id}")
    public ResponseEntity<Airline> getAirline(@PathVariable Long airline_id) {
        return ResponseEntity.ok(service.getAirline(airline_id));
    }

    @PostMapping
    public ResponseEntity<Airline> saveAirline(@RequestBody Airline airline) {
        return new ResponseEntity<>(service.saveAirline(airline), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Airline> updateAirline(@RequestBody Airline airline) {
        return ResponseEntity.ok(service.updateAirline(airline));
    }

    @DeleteMapping("/{airline_id}")
    public ResponseEntity<String> deleteAirline(@PathVariable Long airline_id) {
        service.deleteAirline(airline_id);
        return ResponseEntity.ok("Airline "+airline_id+" was deleted successfully");
    }

    @GetMapping("/airline-name/{name}")
    public ResponseEntity<Airline> getAirlineByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getAirlineByName(name));
    }


    @GetMapping("/airline-airplane/{airline_id}")
    public ResponseAirlineWithAirplanes getAirlineWithAirplanes(@PathVariable Long airline_id) {
        return service.getAirlineWithAirplanes(airline_id);
    }

    @GetMapping("/airline-airplane")
    public List<ResponseAirlineWithAirplanes>  getAllAirlineWithAirplanes() {
        return service.getAllAirlineWithAirplanes();
    }


}
