package com.saraya.Airportservice.proxies;

import com.saraya.Airportservice.bean.Airline;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "airline-service", url = "http://localhost:8084/airlines")
public interface AirlineProxy {

    @GetMapping
    List<Airline> getAllAirlines();

    @GetMapping("/{airline_id}")
    Airline getAirline(@PathVariable Long airline_id);

    @PostMapping
    Airline saveAirline(@RequestBody Airline airline);

    @PutMapping
    Airline updateAirline(@RequestBody Airline airline);

    @DeleteMapping("/{airline_id}")
    String deleteAirline(@PathVariable Long airline_id);
}
