package com.saraya.microservice.airportservice.controller;

import com.saraya.microservice.airportservice.model.Airport;
import com.saraya.microservice.airportservice.model.AirportDto;
import com.saraya.microservice.airportservice.service.AirportService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/arps")
public class AirportController {
    private final AirportService service ;

    public AirportController(AirportService service) {
        this.service = service;
    }
    @GetMapping
    public List<Airport> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Airport getById(@PathVariable int airport_id) {
       return service.getById(airport_id);
    }

    @PostMapping("/")
    public Airport create(@RequestBody AirportDto dto) {
        return service.create(dto);
    }

    @PutMapping("/")
    public Airport update(@RequestBody AirportDto dto) {
        return service.update(dto);
    }

    @GetMapping("/country/city/city/country/arpgs")
    ///arpgs/country/city/{country}/{city}
    public Airport getCountryCity(@PathVariable  String country,@PathVariable String city){

        return service.getCountryCity(country,city);


    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int airport_id) {
        service.delete(airport_id);
    }

   /*@GetMapping("/airport_name/{airport_name}")
    public Airport getIdDept(@PathVariable String airport_name) {
        return  service.getIdArp(airport_name);
    }*/
//    @GetMapping("/country/{country}")
//    public AirportGeo getIdDept(@PathVariable String country) {
//        return service.getIdArp(country);
//    }


}
