package com.saraya.parkingservice.controller;

import com.saraya.parkingservice.model.Parking;
import com.saraya.parkingservice.service.ParkingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final Logger LOGGER = LoggerFactory.getLogger(ParkingController.class);

    private final ParkingService service;

    public ParkingController(ParkingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Parking> getAll(){
        LOGGER.info("List of Passager Parking...");
        return service.getAll();
    }

    @GetMapping("/recup/{name}/{email}")
    public Parking getByNameAndEmail(
            @PathVariable String name ,@PathVariable String email ){
        return service.getByNameAndEmail(name, email);
    }

    @PostMapping
    public Parking create(@RequestBody Parking parking){
        LOGGER.info("CREATING NEW Parking...");
        return service.create(parking);
    }

    @PutMapping
    public Parking update(@RequestBody Parking parking){
        LOGGER.info("Update Passagers PARKING....");
        return service.update(parking);
    }

    @DeleteMapping("delete/{name}/{email}")
    public void deleteByNameAndEmail(
            @PathVariable String name ,
            @PathVariable String email){
        service.deleteByNameAndEmail(name, email);
    }

    @DeleteMapping("/{parkingId}")
    public void deleteById(@PathVariable int parkingId){
        service.deleteById(parkingId);
    }


}
