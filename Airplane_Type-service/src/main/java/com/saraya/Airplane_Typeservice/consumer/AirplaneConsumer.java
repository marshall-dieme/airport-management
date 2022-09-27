package com.saraya.Airplane_Typeservice.consumer;

import com.saraya.Airplane_Typeservice.bean.Airplane;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "airplane-service", url = "http://localhost:8085/airplanes")
public interface AirplaneConsumer {


    @GetMapping
    List<Airplane> getAllAirplanes();

    @GetMapping("/{airplane_id}")
    Airplane getAirplane(@PathVariable Long airplane_id);

    @PostMapping
    Airplane saveAirplane(@RequestBody Airplane airplane);

    @PutMapping
    Airplane updateAirplane(@RequestBody Airplane airplane);


}
