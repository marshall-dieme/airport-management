package com.saraya.airportgeo.controller;


import com.saraya.airportgeo.model.AirportGeo;
import com.saraya.airportgeo.service.AirportGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airportGeo")
public class AirportGeoController {

    @Autowired
    private AirportGeoService airportGeoService;

    @PostMapping("/")
    public AirportGeo save(@RequestBody AirportGeo airportGeo){
        return airportGeoService.save(airportGeo);
    }

    @GetMapping("/{airport_geo_id}")
    public AirportGeo findById(@PathVariable long airport_geo_id){
        return airportGeoService.findById(airport_geo_id);
    }

    @GetMapping("/")
    public List<AirportGeo> getAll(){
        return airportGeoService.findAll();
    }

    @PutMapping("/update")
    public AirportGeo update(@RequestBody AirportGeo airportGeo){
        return airportGeoService.update(airportGeo);
    }

//    @PutMapping("/update")
//    public AirportGeo update(@RequestBody AirportGeo airportGeo){
//        return airportGeoService.update(airportGeo);
//    }

    @DeleteMapping("/delete/{airport_geo_id}")
    public void deleteById(@PathVariable Long airport_geo_id){
        airportGeoService.deleteById(airport_geo_id);
    }
//
//    @DeleteMapping("/delete/{airport_geo_id}")
//    public String deleteById(@PathVariable Long airport_geo_id){
//        return airportGeoService.deleteById(airport_geo_id);
   }





