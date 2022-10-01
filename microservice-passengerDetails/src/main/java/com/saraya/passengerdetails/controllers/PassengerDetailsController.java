package com.saraya.passengerdetails.controllers;

import com.saraya.passengerdetails.dto.PassengerDetailsDto;
import com.saraya.passengerdetails.exceptions.ResourceNotFoundException;
import com.saraya.passengerdetails.mappers.PassengerDetailsMapper;
import com.saraya.passengerdetails.models.PassengerDetails;
import com.saraya.passengerdetails.services.PassengerDetailsService;
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
@RequestMapping(value = "/passengerDetailss")
public class PassengerDetailsController {
    private final PassengerDetailsService passengerDetailsService;
    private final PassengerDetailsMapper passengerDetailsMapper;

    public PassengerDetailsController(PassengerDetailsService passengerDetailsService, PassengerDetailsMapper passengerDetailsMapper) {
        this.passengerDetailsService = passengerDetailsService;
        this.passengerDetailsMapper = passengerDetailsMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PassengerDetailsDto passengerDetailsDto){

        PassengerDetails passengerDetails = passengerDetailsService.add(passengerDetailsMapper.passengerDetailsDtoToPassengerDetails(passengerDetailsDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(passengerDetailsMapper.passengerDetailsToPassengerDetailsDto(passengerDetails));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<PassengerDetails> passengerDetailsList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<PassengerDetails> passengerDetailsPage = this.passengerDetailsService.getPassengerDetailss(pageable);
        passengerDetailsList = passengerDetailsPage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("passengerDetailss",this.passengerDetailsMapper.passengerDetailssToPassengerDetailsDtos(passengerDetailsList));
        response.put("currentPage",passengerDetailsPage.getNumber());
        response.put("totalItems",passengerDetailsPage.getTotalElements());
        response.put("totalPages",passengerDetailsPage.getTotalPages());

        if (passengerDetailsList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<PassengerDetailsDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        PassengerDetails passengerDetails = this.passengerDetailsService.getPassengerDetails(id);

        return new ResponseEntity<PassengerDetailsDto>(this.passengerDetailsMapper.passengerDetailsToPassengerDetailsDto(passengerDetails),HttpStatus.OK);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody PassengerDetailsDto passengerDetailsDto, @PathVariable Long id){
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        PassengerDetails passengerDetails = passengerDetailsService.update(passengerDetailsMapper.passengerDetailsDtoToPassengerDetails(passengerDetailsDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(passengerDetailsMapper.passengerDetailsToPassengerDetailsDto(passengerDetails));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.passengerDetailsService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
