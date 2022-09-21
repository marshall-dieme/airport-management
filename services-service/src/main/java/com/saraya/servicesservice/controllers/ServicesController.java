package com.saraya.servicesservice.controllers;

import com.saraya.servicesservice.dto.ServicesDto;
import com.saraya.servicesservice.mappers.ServicesMapper;
import com.saraya.servicesservice.models.Services;
import com.saraya.servicesservice.services.ServicesService;
import com.saraya.servicesservice.services.exceptions.ResourceNotFoundException;
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
@RequestMapping(value = "/services")
public class ServicesController {
    private final ServicesService servicesService;
    private final ServicesMapper servicesMapper;

    public ServicesController(ServicesService servicesService, ServicesMapper servicesMapper) {
        this.servicesService = servicesService;
        this.servicesMapper = servicesMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ServicesDto servicesDto){

        Services services = servicesService.add(servicesMapper.servicesDtoToServices(servicesDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(servicesMapper.servicesToServicesDto(services));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<Services> servicesList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC);
        Page<Services> servicesPage = this.servicesService.getServicess(pageable);
        servicesList = servicesPage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("servicess",this.servicesMapper.servicesToServicesDtos(servicesList));
        response.put("currentPage",servicesPage.getNumber());
        response.put("totalItems",servicesPage.getTotalElements());
        response.put("totalPages",servicesPage.getTotalPages());

        if (servicesList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ServicesDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Services services = this.servicesService.getServices(id);

        return new ResponseEntity<ServicesDto>(this.servicesMapper.servicesToServicesDto(services),HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.servicesService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
