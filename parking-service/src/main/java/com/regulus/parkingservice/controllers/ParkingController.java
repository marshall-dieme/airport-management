package com.regulus.parkingservice.controllers;

import com.regulus.parkingservice.dtos.ParkingDto;
import com.regulus.parkingservice.models.Parking;
import com.regulus.parkingservice.services.ParkingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping
    public List<Parking> getParkingList(){
        return parkingService.getParking();
    }

    @PostMapping
    public ParkingDto create(@RequestBody ParkingDto parkingDto){
        return parkingService.createParking(parkingDto);
    }

    @PutMapping("/{id}")
    public ParkingDto update(@PathVariable("id") int id, @RequestBody ParkingDto parkingDto){
        return parkingService.updateParking(parkingDto, id);
    }

    @GetMapping("/{id}")
    public ParkingDto getParking(@PathVariable("id") int id ){
        return parkingService.getParking(id);
    }

    @GetMapping("/name/{name}")
    public Integer getParkingId(@PathVariable("name") String name){
        return parkingService.getParkingId(name);
    }

    @DeleteMapping("/{id}")
    public void deleteParking(@PathVariable("id") int id){
        parkingService.deleteParking(id);
    }
}
