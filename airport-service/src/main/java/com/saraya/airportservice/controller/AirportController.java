package com.saraya.airportservice.controller;

import com.saraya.airportservice.model.Airport;
import com.saraya.airportservice.model.AirportDTO;
import com.saraya.airportservice.service.AirportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    private final Logger LOGGER = LoggerFactory.getLogger(AirportController.class);
    public final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }


    @GetMapping
    public List<Airport> getAll(){
        LOGGER.info("getting all airport");
        return service.getAll();
    }

    @GetMapping("/{iata}")
    public Airport getByIata(@PathVariable String iata){
        return service.getByIata(iata);
    }

    @PostMapping
    public Airport create(@RequestBody AirportDTO airport){
        LOGGER.info("CREATING NEW AIRPORT...");
        return service.create(airport);
    }

    @PutMapping
    public Airport update(@RequestBody Airport airport){
        LOGGER.info("Update airport...");
        return service.update(airport);
    }

    @DeleteMapping("delete/{iata}")
    public void deleteByIata(@PathVariable String iata){
        LOGGER.info("Delete Airport by IATA....");
        service.deleteByIata(iata);
    }

    @DeleteMapping("/{airport_id}")
    public void deleteById(@PathVariable int airportId){
        LOGGER.info("Delete airport by ID.....");
        service.deleteById(airportId);
    }

    @GetMapping("/airportName/{airportName}")
    public Integer  findByAirportName(
            @PathVariable String airportName) {
        LOGGER.info("Find airport by airportName");
        return  service.findByAirportName(airportName).getAirportId();
    }

}
