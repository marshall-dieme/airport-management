package com.saraya.Airportservice.proxies;

import com.saraya.Airportservice.bean.Services;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "services-service", url = "http://localhost:8082/services")
public interface ServicesProxy {

    @GetMapping
    List<Services> getAllServices();

    @GetMapping("/{service_id}")
    Services getService(@PathVariable Long service_id);

    @PostMapping
    Services saveService(@RequestBody Services services);

    @PutMapping
    Services updateService(@RequestBody Services services);

    @DeleteMapping("/{service_id}")
    String deleteService(@PathVariable Long service_id);
}
