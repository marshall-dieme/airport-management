package com.saraya.airportservice.controllers;

import com.saraya.airportservice.dto.AirportDto;
import com.saraya.airportservice.exceptions.ResourceNotFoundException;
import com.saraya.airportservice.mappers.AirportMapper;
import com.saraya.airportservice.models.Airport;
import com.saraya.airportservice.services.AirportService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/airports")
public class AirportController {
    private final AirportService airportService;
    private final AirportMapper airportMapper;

    public AirportController(AirportService airportService, AirportMapper airportMapper) {
        this.airportService = airportService;
        this.airportMapper = airportMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AirportDto airportDto){

        Airport airport = airportService.add(airportMapper.airportDtoToAirport(airportDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(airportMapper.airportToAirportDto(airport));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<Airport> airportList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC);
        Page<Airport> airportPage = this.airportService.getAirports(pageable);
        airportList = airportPage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("airports",this.airportMapper.airportsToAirportDtos(airportList));
        response.put("currentPage",airportPage.getNumber());
        response.put("totalItems",airportPage.getTotalElements());
        response.put("totalPages",airportPage.getTotalPages());

        if (airportList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AirportDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Airport airport = this.airportService.getAirport(id);

        return new ResponseEntity<AirportDto>(this.airportMapper.airportToAirportDto(airport),HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.airportService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
