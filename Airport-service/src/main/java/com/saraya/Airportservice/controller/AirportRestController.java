package com.saraya.Airportservice.controller;

import com.saraya.Airportservice.dto.AirlineDto;
import com.saraya.Airportservice.dto.AirportDto;
import com.saraya.Airportservice.dto.Airport_GeoDto;
import com.saraya.Airportservice.dto.ServicesDto;
import com.saraya.Airportservice.model.Airport;
import com.saraya.Airportservice.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RequestMapping("airports")
@RestController
public class AirportRestController {

    private final AirportService service;

    @GetMapping
    public ResponseEntity<List<AirportDto>> getAllAirports() {
        return ResponseEntity.ok(service.getAllAirports());
    }

    @GetMapping("/{airport_id}")
    public ResponseEntity<AirportDto> getAirport(@PathVariable Long airport_id) {
        return ResponseEntity.ok(service.getAirport(airport_id));
    }

    @PostMapping
    public ResponseEntity<Airport> saveAirport(@RequestBody AirportDto airportDto) {
        return new ResponseEntity<>(service.saveAirport(airportDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Airport> updateAirport(@RequestBody AirportDto airportDto) {
        return new ResponseEntity<>(service.saveAirport(airportDto), HttpStatus.OK);
    }

    @DeleteMapping("/{airport_id}")
    public ResponseEntity<String> deleteAirport(@PathVariable Long airport_id) {
        service.deleteAirport(airport_id);
        return ResponseEntity.ok("Airport "+airport_id+" was deleted");
    }



}
