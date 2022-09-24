package com.saraya.Airlineservice.controller;

import com.saraya.Airlineservice.dto.AirplaneDto;
import com.saraya.Airlineservice.model.Airline;
import com.saraya.Airlineservice.service.AirlineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        getAirplaneByRestTemplate(airline);
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

    public void getAirplaneByRestTemplate(Airline airline) {
        Map<String, Long> airplane_value = new HashMap<>();
        airplane_value.put("airplane_id", airline.getAirplane_id());
        AirplaneDto airplaneDto = new RestTemplate()
                .getForEntity("http://localhost:8085/airplanes/{airplane_id}",
                        AirplaneDto.class, airplane_value).getBody();
        if (airplaneDto != null) {
            airline.setAirplane_id(airplaneDto.getAirplane_id());
        }
    }
}
