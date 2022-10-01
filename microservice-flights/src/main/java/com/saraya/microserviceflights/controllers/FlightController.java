package com.saraya.microserviceflights.controllers;

import com.saraya.microserviceflights.dto.FlightDto;
import com.saraya.microserviceflights.exceptions.ResourceNotFoundException;
import com.saraya.microserviceflights.mappers.FlightMapper;
import com.saraya.microserviceflights.models.Flight;
import com.saraya.microserviceflights.services.FlightService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/flights")
public class FlightController {
    private final FlightService flightService;
    private final FlightMapper flightMapper;

    public FlightController(FlightService flightService, FlightMapper flightMapper) {
        this.flightService = flightService;
        this.flightMapper = flightMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody FlightDto flightDto){

        Flight flight = flightService.add(flightMapper.flightDtoToFlight(flightDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(flightMapper.flightToFlightDto(flight));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<Flight> flightList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Flight> flightPage = this.flightService.getFlights(pageable);
        flightList = flightPage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("flights",this.flightMapper.flightsToFlightDtos(flightList));
        response.put("currentPage",flightPage.getNumber());
        response.put("totalItems",flightPage.getTotalElements());
        response.put("totalPages",flightPage.getTotalPages());

        if (flightList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<FlightDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Flight flight = this.flightService.getFlight(id);

        return new ResponseEntity<FlightDto>(this.flightMapper.flightToFlightDto(flight),HttpStatus.OK);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody FlightDto flightDto, @PathVariable Long id){
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Flight flight = flightService.update(flightMapper.flightDtoToFlight(flightDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(flightMapper.flightToFlightDto(flight));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.flightService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
