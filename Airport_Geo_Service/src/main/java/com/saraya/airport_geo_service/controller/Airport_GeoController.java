package com.saraya.airport_geo_service.controller;

import com.saraya.airport_geo_service.model.Airport_Geo;
import com.saraya.airport_geo_service.service.Airport_GeoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airport_geo")
public class Airport_GeoController {
    private final Airport_GeoService service;

    public Airport_GeoController(Airport_GeoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airport_Geo> getAll() {
        return service.getAll();
    }

    @GetMapping("/{airport_geo_id}")
    public Airport_Geo getByName(@PathVariable Long airport_geo_id) {
        return service.getById(airport_geo_id);
    }

    @PostMapping
    public Airport_Geo create(@RequestBody Airport_Geo ag) {
        return service.create(ag);
    }

    @PutMapping
    public Airport_Geo update(@RequestBody Airport_Geo ag) {
        return service.update(ag);
    }

    @DeleteMapping("delete/{airport_geo_id}")
    public void deleteByName(@PathVariable Long airport_geo_id) {
        service.deleteByName(airport_geo_id);
    }

    @DeleteMapping("/{airport_geo_id}")
    public void delete(@PathVariable Long airport_geo_id) {
        service.delete(airport_geo_id);
    }
}
