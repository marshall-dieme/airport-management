package com.saraya.passengers.controllers;

import com.saraya.passengers.dto.PassengerDto;
import com.saraya.passengers.exceptions.ResourceNotFoundException;
import com.saraya.passengers.mappers.PassengerMapper;
import com.saraya.passengers.models.Passenger;
import com.saraya.passengers.services.PassengerService;
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
@RequestMapping(value = "/passengers")
public class PassengerController {
    private final PassengerService passengerService;
    private final PassengerMapper passengerMapper;

    public PassengerController(PassengerService passengerService, PassengerMapper passengerMapper) {
        this.passengerService = passengerService;
        this.passengerMapper = passengerMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PassengerDto passengerDto){

        Passenger passenger = passengerService.add(passengerMapper.passengerDtoToPassenger(passengerDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(passengerMapper.passengerToPassengerDto(passenger));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<Passenger> passengerList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Passenger> passengerPage = this.passengerService.getPassengers(pageable);
        passengerList = passengerPage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("passengers",this.passengerMapper.passengersToPassengerDtos(passengerList));
        response.put("currentPage",passengerPage.getNumber());
        response.put("totalItems",passengerPage.getTotalElements());
        response.put("totalPages",passengerPage.getTotalPages());

        if (passengerList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<PassengerDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Passenger passenger = this.passengerService.getPassenger(id);

        return new ResponseEntity<PassengerDto>(this.passengerMapper.passengerToPassengerDto(passenger),HttpStatus.OK);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody PassengerDto passengerDto, @PathVariable Long id){
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Passenger passenger = passengerService.update(passengerMapper.passengerDtoToPassenger(passengerDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(passengerMapper.passengerToPassengerDto(passenger));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.passengerService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
