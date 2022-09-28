package com.saraya.PassengerDetailsservice.controller;

import com.saraya.PassengerDetailsservice.bean.ResponsePassengerWithDetails;
import com.saraya.PassengerDetailsservice.dto.PassengerDetailsDto;
import com.saraya.PassengerDetailsservice.model.PassengerDetails;
import com.saraya.PassengerDetailsservice.service.PassengerDetailService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("passenger-details")
@RestController
public class PassengerDetailsRestController {

    private final PassengerDetailService service;
    private final Logger log = LoggerFactory.getLogger(PassengerDetails.class);


    @GetMapping
    public ResponseEntity<List<PassengerDetailsDto>> getAllPassengerDetails() {
        return ResponseEntity.ok(service.getAllPassengerDetails());
    }

    @GetMapping("/{passenger_details_id}")
    public ResponseEntity<PassengerDetails> getPassengerDetails(@PathVariable Long passenger_details_id) {
        return ResponseEntity.ok(service.getPassengerDetails(passenger_details_id));
    }

    @GetMapping("/passengers-details/{passenger_details_id}")
    public ResponsePassengerWithDetails getPassengerWithAllDetails(@PathVariable Long passenger_details_id) {
        return service.getPassengerWithAllDetails(passenger_details_id);
    }

    @PostMapping
    public ResponseEntity<PassengerDetails> savePassengerDetails(@RequestBody PassengerDetailsDto dto) {
        log.debug(dto.toString());
        return new ResponseEntity<>(service.savePassengerDetails(dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PassengerDetails> updatePassengerDetails(@RequestBody PassengerDetailsDto passengerDetails) {
        return ResponseEntity.ok(service.updatePassengerDetails(passengerDetails));
    }

    @DeleteMapping("/{passenger_detail_id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long passenger_detail_id){
        service.deletePassengerDetails(passenger_detail_id);
        return ResponseEntity.ok("Passenger "+passenger_detail_id+" was deleted");
    }
}
