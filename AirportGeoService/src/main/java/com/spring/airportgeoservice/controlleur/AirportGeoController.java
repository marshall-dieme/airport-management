package com.spring.airportgeoservice.controlleur;

import com.spring.airportgeoservice.bean.AirportGeo;
import com.spring.airportgeoservice.repo.AirportGeoRepo;
import com.spring.airportgeoservice.service.AirportGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airportgeo")
public class AirportGeoController {

    @Autowired
    private AirportGeoService service;

    @GetMapping
    public List<AirportGeo> getAll(){
        return service.getAll();
    }

    @PostMapping
    public  AirportGeo create(@RequestBody AirportGeo airportGeo){
        return service.create(airportGeo);
    }

    @PutMapping("/{id}")
    public AirportGeo update( @PathVariable("id") int id , @RequestBody AirportGeo airportGeo){
        return service.update(id, airportGeo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }



}
