package com.saraya.Airlineservice.proxies;

import com.saraya.Airlineservice.bean.Airplane;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "airplane-service", url = "http://localhost:8085/airplanes")
public interface AirplaneProxy {

    @GetMapping
    List<Airplane> getAllAirplanes();

    @GetMapping("/{airplane_id}")
    Airplane getAirplane(@PathVariable Long airplane_id);

    @PostMapping
    Airplane saveAirplane(@RequestBody Airplane airplane);

    @PutMapping
    Airplane updateAirplane(@RequestBody Airplane airplane);

    @DeleteMapping("/{airplane_id}")
    String deleteAirplane(@PathVariable Long airplane_id);

}
