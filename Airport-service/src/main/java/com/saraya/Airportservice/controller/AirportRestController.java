package com.saraya.Airportservice.controller;

import com.saraya.Airportservice.dto.AirportDto;
import com.saraya.Airportservice.bean.ResponseAirportAndDetails;
import com.saraya.Airportservice.model.Airport;
import com.saraya.Airportservice.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<>(service.updateAirport(airportDto), HttpStatus.OK);
    }

    @DeleteMapping("/{airport_id}")
    public ResponseEntity<String> deleteAirport(@PathVariable Long airport_id) {
        service.deleteAirport(airport_id);
        return ResponseEntity.ok("Airport "+airport_id+" was deleted");
    }

    @GetMapping("/airport-details/all")
    public List<ResponseAirportAndDetails> getAllAirportsWithDetails() {
        return service.getAllAirportsWithDetails();
    }

    @GetMapping("/airport-details/{airport_id}")
    public ResponseAirportAndDetails getAirportWithAllDetails(@PathVariable Long airport_id) {
        return service.getAirportWithAllDetails(airport_id);
    }


}
