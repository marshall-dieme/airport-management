package com.saraya.airport.controller;

import com.saraya.airport.model.Airport;
import com.saraya.airport.service.AirportService;
import com.saraya.airport.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService service;

    @PostMapping("/")
    public Airport save(@RequestBody Airport airport){
        return service.save(airport);
    }

    @GetMapping("/")
    public List<Airport> getAll(){
        return service.findAll();
    }

//    @GetMapping("/{id}")
//    public ResponseTemplateVo getAirportWithAirportGeo(@PathVariable("id") long airport_id ){
//        return service.getAirportWithAirportGeo(airport_id);
//    }
//
//    @GetMapping("/service/{service_id}")
//    public ResponseTemplateVo getAirportWithService(@PathVariable("service_id") long service_id ){
//        return service.getAirportWithService(service_id);
//    }

    @GetMapping("/{airport_id}")
    public Airport getAirportById(@PathVariable long airport_id){
        return service.findById(airport_id);
    }

    @GetMapping("/airport-AirportGeo-Service/services/{id}")
    public ResponseTemplateVo getAirportWithAirportGeoWithService(@PathVariable("id") long service_id ){
        return service.findAirportAirportGeoServiceAirline(service_id);
    }


    @PutMapping
    public Airport update(@RequestBody Airport airport){
        return service.update(airport);
    }

    @DeleteMapping("delete/{airport_id}")
    public void deleteById(@PathVariable long airport_id){
        service.deleteById(airport_id);
    }


}

