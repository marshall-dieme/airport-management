package com.example.parkingservice.controller;

import com.example.parkingservice.model.Parking;
import com.example.parkingservice.model.ParkingDto;
import com.example.parkingservice.service.ParkingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    private final ParkingService service;

    public ParkingController(ParkingService service) {
        this.service = service;
    }


    @GetMapping
    public List<Parking> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Parking> getById(@PathVariable Long ParkingId) {
        return service.getById(ParkingId);
    }


    @GetMapping("/passportNo/{passportNo}")
    public List <Parking> getParkingByPassenger(@PathVariable String passportNo) {
        return (List<Parking>) service.getParkingByPassenger(passportNo);
    }


    @PostMapping
    public Parking create(@RequestBody ParkingDto dto) {
        return service.create(dto);
    }

    @PutMapping
    public Parking update(@RequestBody ParkingDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
