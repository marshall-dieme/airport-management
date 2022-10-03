package com.saraya.microserviceairportgeos.controllers;

import com.saraya.microserviceairportgeos.dto.AirportGeoDto;
import com.saraya.microserviceairportgeos.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairportgeos.mappers.AirportGeoMapper;
import com.saraya.microserviceairportgeos.models.AirportGeo;
import com.saraya.microserviceairportgeos.services.AirportGeoService;
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
@RequestMapping(value = "/airportgeos")
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
        Pageable pageable = PageRequest.of(page, size);
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody AirportGeoDto airportGeoDto,@PathVariable Long id){
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        AirportGeo airportGeo = airportGeoService.update(airportGeoMapper.airportGeoDtoToAirportGeo(airportGeoDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(airportGeoMapper.airportGeoToAirportGeoDto(airportGeo));
    }

    @GetMapping(value = "/airportgeo_id/{id}")
    public ResponseEntity<Long> findByairportgeoId(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        AirportGeo airportGeo = this.airportGeoService.getAirportGeo(id);

        return new ResponseEntity<Long>(this.airportGeoMapper.airportGeoToAirportGeoDto(airportGeo).getAirport_geo_id(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.airportGeoService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
