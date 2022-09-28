package com.example.ivo.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ivo.entiti.Service;


@FeignClient(url = "${Airplservice_.url}", value = "airplservice-feign-client",
path = "/api/cc/services")
public interface airportserv_feignclient  {
	@GetMapping("/services/{serviceid}")
	List<Service> findByAirportGeo(@PathVariable("serviceid") Long serviceid);
	
}
