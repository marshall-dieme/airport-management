package com.saraya.Parkingservice.controller;

import com.saraya.Parkingservice.dto.ParkingDto;
import com.saraya.Parkingservice.model.Parking;
import com.saraya.Parkingservice.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("parkings")
@RestController
public class ParkingRestController {

    private final ParkingService service;

    @GetMapping
    public ResponseEntity<List<ParkingDto>> getAllParking() {
        return ResponseEntity.ok(service.getAllParking());
    }

    @GetMapping("/{parking_id}")
    public ResponseEntity<ParkingDto> getParking(@PathVariable Long parking_id) {
        return ResponseEntity.ok(service.getParking(parking_id));
    }

    @PostMapping
    public ResponseEntity<Parking> saveParking(@RequestBody ParkingDto parking) {
        return new ResponseEntity<>(service.saveParking(parking), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Parking> updateParking(@RequestBody ParkingDto parking) {
        return ResponseEntity.ok(service.updateParking(parking));
    }

}
