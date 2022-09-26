package com.saraya.airportgeoservice.controllers;

import com.saraya.airportgeoservice.dto.AirportGeoDto;
import com.saraya.airportgeoservice.exceptions.ResourceNotFoundException;
import com.saraya.airportgeoservice.mappers.AirportGeoMapper;
import com.saraya.airportgeoservice.models.AirportGeo;
import com.saraya.airportgeoservice.services.AirportGeoService;
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
@RequestMapping(value = "/airportGeos")
public class AirportGeoController {
    private final AirportGeoService airportGeoService;
    private final AirportGeoMapper airportGeoMapper;

    public AirportGeoController(AirportGeoService airportGeoService, AirportGeoMapper airportGeoMapper) {
        this.airportGeoService = airportGeoService;
        this.airportGeoMapper = airportGeoMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AirportGeoDto airportGeoDto){

        AirportGeo airportGeo = airportGeoService.add(airportGeoMapper.airportGeoDtoToAirportGeo(airportGeoDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(airportGeoMapper.airportGeoToAirportGeoDto(airportGeo));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<AirportGeo> airportGeoList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC);
        Page<AirportGeo> airportGeoPage = this.airportGeoService.getAirportGeos(pageable);
        airportGeoList = airportGeoPage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("airportGeos",this.airportGeoMapper.airportGeosToAirportGeoDtos(airportGeoList));
        response.put("currentPage",airportGeoPage.getNumber());
        response.put("totalItems",airportGeoPage.getTotalElements());
        response.put("totalPages",airportGeoPage.getTotalPages());

        if (airportGeoList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AirportGeoDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        AirportGeo airportGeo = this.airportGeoService.getAirportGeo(id);

        return new ResponseEntity<AirportGeoDto>(this.airportGeoMapper.airportGeoToAirportGeoDto(airportGeo),HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.airportGeoService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
