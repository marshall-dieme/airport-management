package com.saraya.airportservice.controller;

import com.saraya.airportservice.bean.Airport;
import com.saraya.airportservice.dto.AirportDto;
import com.saraya.airportservice.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Airport")
public class AirportController {

    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    @PostMapping("/{idAirport}/{country}/{city}")
    public Airport putAirportGeoByContryAndCity(@PathVariable("idAirport") int idAirport, @PathVariable("country") String country,
                                                @PathVariable("city") String city){
        return service.putIdAirportGeoForAirport(idAirport, country, city);
    }

    @PostMapping("service/{idAirport}/{serviceName}")
    public Airport putServicesForAirport(@PathVariable("idAirport") int idAirport, @PathVariable("serviceName") String serviceName){
        return service.putServiceForAirport(idAirport, serviceName);
    }

    @PostMapping("airline/{idAirport}/{airlineName}")
    public Airport putAirlineForAirport(@PathVariable("idAirport") int idAirport, @PathVariable("airlineName") String airlineName){
        return service.putAirlineForAirport(idAirport, airlineName);
    }

    @GetMapping
    public List<Airport> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Airport create(@RequestBody AirportDto dto){
        return service.create(dto);
    }

    @GetMapping("/{airportName}")
    public int getIdByName(@PathVariable("airportName") String airportName){
        return service.getIdAirportByName(airportName);
    }

    @PutMapping
    public AirportDto update(@RequestBody AirportDto dto){
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }

}
