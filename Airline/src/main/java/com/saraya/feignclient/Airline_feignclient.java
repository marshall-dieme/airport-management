package com.saraya.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.saraya.entit.Airlin;
@FeignClient(url = "${Airline.url}", value = "airline-feign-client",
path = "/api/pu/airline")
public interface Airline_feignclient {

          @GetMapping("/airline/{airlineid}")
				List<Airlin> findByAirportGeo(@PathVariable("airlineid") Long airlineid);
				
}