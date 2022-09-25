package com.example.passengerservice.controller;

import com.example.passengerservice.model.Passenger;
import com.example.passengerservice.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    private final PassengerService service;


    public PassengerController(PassengerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Passenger> getAll(){
        return service.getAll();
    }

    /*@GetMapping("/{city}/{country}")
    public Passenger getByCityAndCountry(String city, String country){
        return service.getByCityAndCountry(city,country);
    }*/

    @GetMapping("/{passengerNo}")
    public Long getIdPassenger(@PathVariable String passengerNo){
        return service.getIdPassenger(passengerNo);
    }


    @PostMapping("/")
    public Passenger create(@RequestBody Passenger passenger) {

        return service.create(passenger);
    }

    @PutMapping("/")
    public Passenger update (@RequestBody Passenger airportGeo){
        return service.update(airportGeo);
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }
}
