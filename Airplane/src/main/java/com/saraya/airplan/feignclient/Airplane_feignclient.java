package com.saraya.airplan.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.saraya.airplan.entity.Airplan;

@FeignClient(url = "${Airplane.url}", value = "airplane-feign-client",
path = "/api/pe/airplanes")
public interface Airplane_feignclient {
	@GetMapping("/airplanees/{airplaneid}")
	List<Airplan> findByAirportGeo(@PathVariable("airplaneid") Long airplaneid);
	
}
