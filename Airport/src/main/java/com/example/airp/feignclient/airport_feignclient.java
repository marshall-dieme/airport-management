package com.example.airp.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.airp.entiti3.Airpor;

@FeignClient(url = "${Airport.url}", value = "airport-feign-client",
path = "/api/airports")
public interface airport_feignclient {
	@GetMapping("/airports/{airporid}")
	List<Airpor> findByAirportGeo(@PathVariable("airporid") Long airporid);
	
}
