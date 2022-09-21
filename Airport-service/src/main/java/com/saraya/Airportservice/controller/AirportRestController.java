package com.saraya.Airportservice.controller;

import com.saraya.Airportservice.dto.Airport_GeoDto;
import com.saraya.Airportservice.dto.ServicesDto;
import com.saraya.Airportservice.model.Airport;
import com.saraya.Airportservice.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RequestMapping("airports")
@RestController
public class AirportRestController {

    private final AirportService service;

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        return ResponseEntity.ok(service.getAllAirports());
    }

    @GetMapping("/{airport_id}")
    public ResponseEntity<Airport> getAirport(@PathVariable Long airport_id) {
        return ResponseEntity.ok(service.getAirport(airport_id));
    }

    @PostMapping
    public ResponseEntity<Airport> saveAirport(@RequestBody Airport airport) {
        getCountryByRestTemplate(airport);
        return new ResponseEntity<>(service.saveAirport(airport), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Airport> updateAirport(@RequestBody Airport airport) {
        return new ResponseEntity<>(service.saveAirport(airport), HttpStatus.OK);
    }

    @DeleteMapping("/{airport_id}")
    public ResponseEntity<String> deleteAirport(@PathVariable Long airport_id) {
        service.deleteAirport(airport_id);
        return ResponseEntity.ok("Airport "+airport_id+" was deleted");
    }

    public void getCountryByRestTemplate(Airport airport) {
        Map<String,String>  values = new HashMap<>();
        values.put("country", airport.getAirport_geo_country());
        Airport_GeoDto dto = new RestTemplate()
                .getForEntity("http://localhost:8080/airports-geo/country/{country}",
                        Airport_GeoDto.class, values).getBody();
        if (dto != null) {
            airport.setAirport_geo_country(dto.getCountry());
        }

        Map<String,String>  service_value = new HashMap<>();
        service_value.put("name", airport.getService_name());
        ServicesDto servicesDto = new RestTemplate()
                .getForEntity("http://localhost:8082/services/service-name/{name}",
                        ServicesDto.class, service_value).getBody();
        if (servicesDto != null) {
            airport.setService_name(servicesDto.getServices_name());
        }
    }


}
