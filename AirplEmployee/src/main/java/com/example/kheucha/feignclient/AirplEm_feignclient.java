package com.example.kheucha.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.kheucha.entities.Employee;

@FeignClient(url = "${AirplEmployee.url}", value = "airplemployee-feign-client",
path = "/api/vv/employees")
public interface AirplEm_feignclient {
	@GetMapping("/services/{employeeid}")
	List<Employee> findByAirportGeo(@PathVariable("employeeid") Long employeeid);
	

}
