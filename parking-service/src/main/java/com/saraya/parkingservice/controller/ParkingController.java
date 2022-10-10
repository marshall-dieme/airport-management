package com.saraya.parkingservice.controller;

import com.saraya.parkingservice.bean.Parking;
import com.saraya.parkingservice.dto.ParkingDto;
import com.saraya.parkingservice.service.ParkingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Parking")
public class ParkingController {

    private final ParkingService service;

    public ParkingController(ParkingService service) {
        this.service = service;
    }

    @PostMapping("/passenger/{parkingId}/{passportNo}")
    public Parking putPassengerForParking(@PathVariable("parkingId") int parkingId, @PathVariable("passportNo") int passportNo){
        return service.putPassengerForParking(parkingId, passportNo);
    }

    @GetMapping("/{name}")
    public int idBooking(@PathVariable("name") String name){
        return service.getId(name);
    }

    @GetMapping
    public List<Parking> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Parking create(@RequestBody ParkingDto dto){
        return service.create(dto);
    }

}
