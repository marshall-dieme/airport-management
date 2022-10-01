package com.saraya.microserviceairplanes.controllers;

import com.saraya.microserviceairplanes.dto.AirplaneDto;
import com.saraya.microserviceairplanes.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairplanes.mappers.AirplaneMapper;
import com.saraya.microserviceairplanes.models.Airplane;
import com.saraya.microserviceairplanes.services.AirplaneService;
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
@RequestMapping(value = "/airplanes")
public class AirplaneController {
    private final AirplaneService airplaneService;
    private final AirplaneMapper airplaneMapper;

    public AirplaneController(AirplaneService airplaneService, AirplaneMapper airplaneMapper) {
        this.airplaneService = airplaneService;
        this.airplaneMapper = airplaneMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AirplaneDto airplaneDto){

        Airplane airplane = airplaneService.add(airplaneMapper.airplaneDtoToAirplane(airplaneDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(airplaneMapper.airplaneToAirplaneDto(airplane));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<Airplane> airplaneList = new ArrayList<>();

        Pageable pageable = PageRequest.of(page, size );
        Page<Airplane> airplanePage = this.airplaneService.getAirplanes(pageable);
        airplaneList = airplanePage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("airplanes",this.airplaneMapper.airplanesToAirplaneDtos(airplaneList));
        response.put("currentPage",airplanePage.getNumber());
        response.put("totalItems",airplanePage.getTotalElements());
        response.put("totalPages",airplanePage.getTotalPages());

        if (airplaneList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AirplaneDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Airplane airplane = this.airplaneService.getAirplane(id);

        return new ResponseEntity<AirplaneDto>(this.airplaneMapper.airplaneToAirplaneDto(airplane),HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.airplaneService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
