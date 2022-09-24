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

    @GetMapping("/{id}")
    public ResponseTemplateVo getAirportWithAirportGeo(@PathVariable("id") long airport_id ){
        return service.getAirportWithAirportGeo(airport_id);
    }

//    @GetMapping("/{airport_name}")
//    public Airport getByName(@PathVariable String airport_name){
//        return service.findByAirportName(airport_name);
//    }

    @PutMapping("/update")
    public Airport update(@RequestBody Airport airport){
        return service.update(airport);
    }

    @DeleteMapping("delete/{airport_id}")
    public void deleteById(@PathVariable long airport_id){
        service.deleteById(airport_id);
    }


}

