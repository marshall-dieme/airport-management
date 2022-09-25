package com.saraya.Airport.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.Airport.dto.AirportAirlineDTO;
import com.saraya.Airport.dto.AirportServicesDTO;
import com.saraya.Airport.service.AirportService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class AirportController {
    
    private final AirportService airportService;

    @GetMapping("/airport-services")
    public List<AirportServicesDTO> getAllAirportServices(){
        return airportService.getAllAirportServices();
    }
    @GetMapping("/airport-airline")
    public List<AirportAirlineDTO> getAllAirportAirline(){
        return airportService.getAllAirportAirlines();
    }




}