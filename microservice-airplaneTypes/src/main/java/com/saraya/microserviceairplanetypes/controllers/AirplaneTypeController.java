package com.saraya.microserviceairplanetypes.controllers;

import com.saraya.microserviceairplanetypes.dto.AirplaneTypeDto;
import com.saraya.microserviceairplanetypes.exceptions.ResourceNotFoundException;
import com.saraya.microserviceairplanetypes.mappers.AirplaneTypeMapper;
import com.saraya.microserviceairplanetypes.models.AirplaneType;
import com.saraya.microserviceairplanetypes.services.AirplaneTypeService;
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
@RequestMapping(value = "/airplanetypes")
public class AirplaneTypeController {
    private final AirplaneTypeService airplaneTypeService;
    private final AirplaneTypeMapper airplaneTypeMapper;

    public AirplaneTypeController(AirplaneTypeService airplaneTypeService, AirplaneTypeMapper airplaneTypeMapper) {
        this.airplaneTypeService = airplaneTypeService;
        this.airplaneTypeMapper = airplaneTypeMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AirplaneTypeDto airplaneTypeDto) throws ResourceNotFoundException {

        AirplaneType airplaneType = airplaneTypeService.add(airplaneTypeMapper.airplaneTypeDtoToAirplaneType(airplaneTypeDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(airplaneTypeMapper.airplaneTypeToAirplaneTypeDto(airplaneType));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<AirplaneType> airplaneTypeList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<AirplaneType> airplaneTypePage = this.airplaneTypeService.getAirplaneTypes(pageable);
        airplaneTypeList = airplaneTypePage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("airplaneTypes",this.airplaneTypeMapper.airplaneTypesToAirplaneTypeDtos(airplaneTypeList));
        response.put("currentPage",airplaneTypePage.getNumber());
        response.put("totalItems",airplaneTypePage.getTotalElements());
        response.put("totalPages",airplaneTypePage.getTotalPages());

        if (airplaneTypeList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.FOUND);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AirplaneTypeDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        AirplaneType airplaneType = this.airplaneTypeService.getAirplaneType(id);

        return new ResponseEntity<AirplaneTypeDto>(this.airplaneTypeMapper.airplaneTypeToAirplaneTypeDto(airplaneType),HttpStatus.FOUND);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AirplaneTypeDto> update(@RequestBody AirplaneTypeDto airplaneTypeDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (airplaneTypeDto==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        AirplaneType airplaneType = this.airplaneTypeService.update(this.airplaneTypeMapper.airplaneTypeDtoToAirplaneType(airplaneTypeDto));

        return new ResponseEntity<AirplaneTypeDto>(this.airplaneTypeMapper.airplaneTypeToAirplaneTypeDto(airplaneType),HttpStatus.CREATED);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.airplaneTypeService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
