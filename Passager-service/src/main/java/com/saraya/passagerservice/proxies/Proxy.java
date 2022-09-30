package com.saraya.passagerservice.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.saraya.passagerservice.model.PassengerDto;


@FeignClient(name="passagerDetails-service", url = "localhost:8800/passagerDetails")
public interface Proxy {
	@PostMapping
	PassengerDto create(@RequestBody PassengerDto passengerDto);

}