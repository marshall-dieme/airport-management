package com.saraya.Airport_Geoservice.controller;

import com.saraya.Airport_Geoservice.model.Airport_Geo;
import com.saraya.Airport_Geoservice.service.Airport_GeoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/airports-geo")
public class Airport_GeoRest {

    private final Airport_GeoService service;

    @GetMapping
    public ResponseEntity<List<Airport_Geo>> getAllAirportGeo() {
        return ResponseEntity.ok(service.getAllAirportGeo());
    }

    @GetMapping("/{airport_geo_id}")
    public ResponseEntity<Airport_Geo> getAirportGeo(@PathVariable Long airport_geo_id) {
        return ResponseEntity.ok(service.getAirportGeo(airport_geo_id));
    }

    @PostMapping
    public ResponseEntity<Airport_Geo> saveAirport_Geo(@RequestBody Airport_Geo airport_geo) {
        return new ResponseEntity<>(service.saveAirportGeo(airport_geo), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Airport_Geo> updateAirport_Geo(@RequestBody Airport_Geo airport_geo) {
        return ResponseEntity.ok(service.saveAirportGeo(airport_geo));
    }

    @DeleteMapping("/{airport_geo_id}")
    public ResponseEntity<String> deleteAirport_Geo(@PathVariable Long airport_geo_id) {
        service.deleteAirport_Geo(airport_geo_id);
        return ResponseEntity.ok("Airport_Geo "+airport_geo_id+" has been deleted");
    }
}
