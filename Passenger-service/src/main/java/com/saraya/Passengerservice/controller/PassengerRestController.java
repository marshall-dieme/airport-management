package com.saraya.Passengerservice.controller;

import com.saraya.Passengerservice.model.Passenger;
import com.saraya.Passengerservice.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("passengers")
@RestController
public class PassengerRestController {

    private final PassengerService service;

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        return ResponseEntity.ok(service.getAllPassengers());
    }

    @GetMapping("/{passenger_id}")
    public ResponseEntity<Passenger> getPassenger(@PathVariable Long passenger_id) {
        return ResponseEntity.ok(service.getPassenger(passenger_id));
    }

    @PostMapping
    public ResponseEntity<Passenger> savePassenger(@RequestBody Passenger passenger) {
        return new ResponseEntity<>(service.savePassenger(passenger), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger) {
        return ResponseEntity.ok(service.updatePassenger(passenger));
    }

    @DeleteMapping("/{passenger_id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long passenger_id) {
        service.deletePassenger(passenger_id);
        return ResponseEntity.ok("Passenger "+passenger_id+" was deleted successfully");
    }

    @GetMapping("/passport-no/{passport_no}")
    public ResponseEntity<Passenger> getPassengerByPassenger_no(@PathVariable String passport_no) {
        return ResponseEntity.ok(service.getPassengerByPassenger_no(passport_no));
    }

}
