package com.saraya.microserviceparkings.controllers;

import com.saraya.microserviceparkings.dto.ParkingDto;
import com.saraya.microserviceparkings.exceptions.ResourceNotFoundException;
import com.saraya.microserviceparkings.mappers.ParkingMapper;
import com.saraya.microserviceparkings.models.Parking;
import com.saraya.microserviceparkings.services.ParkingService;
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
@RequestMapping(value = "/parkings")
public class ParkingController {
    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ParkingDto parkingDto){

        Parking parking = parkingService.add(parkingMapper.parkingDtoToParking(parkingDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingMapper.parkingToParkingDto(parking));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<Parking> parkingList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Parking> parkingPage = this.parkingService.getParkings(pageable);
        parkingList = parkingPage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("parkings",this.parkingMapper.parkingsToParkingDtos(parkingList));
        response.put("currentPage",parkingPage.getNumber());
        response.put("totalItems",parkingPage.getTotalElements());
        response.put("totalPages",parkingPage.getTotalPages());

        if (parkingList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ParkingDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Parking parking = this.parkingService.getParking(id);

        return new ResponseEntity<ParkingDto>(this.parkingMapper.parkingToParkingDto(parking),HttpStatus.OK);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody ParkingDto parkingDto, @PathVariable Long id){
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Parking parking = parkingService.update(parkingMapper.parkingDtoToParking(parkingDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingMapper.parkingToParkingDto(parking));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.parkingService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
