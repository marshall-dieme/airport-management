package com.saraya.parking.controller;

import com.saraya.parking.dto.ParkingDto;
import com.saraya.parking.model.Parking;
import com.saraya.parking.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parking")
@AllArgsConstructor
public class ParkingController {
    private final ParkingService service;

    @GetMapping
    public List<Parking> getAll() {
        return service.getAllParking();
    }

    @GetMapping("/{parking_id}")
    public Parking getById(@PathVariable("parking_id") Long parking_id) {

        return service.getByIdParking(parking_id);
    }

    @PostMapping
    public Parking create(@RequestBody ParkingDto parkingDto) {

        return service.createParking(parkingDto);
    }

    @PutMapping
    public Parking edit(@RequestBody ParkingDto parkingDto) {
        return service.updateParking(parkingDto);
    }

    @DeleteMapping("/{parking_id}")
    public void delete(@PathVariable("parking_id") Long parking_id) {
        service.deleteParking(parking_id);
    }


}
