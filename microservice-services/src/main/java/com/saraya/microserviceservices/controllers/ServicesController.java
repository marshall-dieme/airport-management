package com.saraya.microserviceservices.controllers;

import com.saraya.microserviceservices.dto.ServicesDto;
import com.saraya.microserviceservices.exceptions.ResourceNotFoundException;
import com.saraya.microserviceservices.mappers.ServicesMapper;
import com.saraya.microserviceservices.models.Services;
import com.saraya.microserviceservices.services.ServicesService;
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
        Pageable pageable = PageRequest.of(page, size);
        Page<Services> servicesPage = this.servicesService.getServicess(pageable);
        servicesList = servicesPage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("services",this.servicesMapper.servicesToServicesDtos(servicesList));
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

    @GetMapping(value = "/services_id/{id}")
    public ResponseEntity<Long> findByServicesId(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Services services = this.servicesService.getServices(id);

        return new ResponseEntity<Long>(this.servicesMapper.servicesToServicesDto(services).getServices_id(),HttpStatus.OK);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody ServicesDto servicesDto, @PathVariable Long id){
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

        Services services = servicesService.update(servicesMapper.servicesDtoToServices(servicesDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(servicesMapper.servicesToServicesDto(services));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.servicesService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
