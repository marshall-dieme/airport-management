package com.saraya.microserviceairlines.controllers;

import com.saraya.microserviceairlines.dto.AirlineDto;
import com.saraya.microserviceairlines.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairlines.mappers.AirlineMapper;
import com.saraya.microserviceairlines.models.Airline;
import com.saraya.microserviceairlines.services.AirlineService;
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
@RequestMapping(value = "/airlines")
public class AirlineController {
    private final AirlineService airlineService;
    private final AirlineMapper airlineMapper;

    public AirlineController(AirlineService airlineService, AirlineMapper airlineMapper) {
        this.airlineService = airlineService;
        this.airlineMapper = airlineMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AirlineDto airlineDto){

        Airline airline = airlineService.add(airlineMapper.airlineDtoToAirline(airlineDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(airlineMapper.airlineToAirlineDto(airline));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<Airline> airlineList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC);
        Page<Airline> airlinePage = this.airlineService.getAirlines(pageable);
        airlineList = airlinePage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("airlines",this.airlineMapper.airlinesToAirlineDtos(airlineList));
        response.put("currentPage",airlinePage.getNumber());
        response.put("totalItems",airlinePage.getTotalElements());
        response.put("totalPages",airlinePage.getTotalPages());

        if (airlineList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AirlineDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Airline airline = this.airlineService.getAirline(id);

        return new ResponseEntity<AirlineDto>(this.airlineMapper.airlineToAirlineDto(airline),HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.airlineService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
