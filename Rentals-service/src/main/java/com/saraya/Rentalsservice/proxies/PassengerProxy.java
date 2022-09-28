package com.saraya.Rentalsservice.proxies;

import com.saraya.Rentalsservice.bean.Passenger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "passenger-service", url = "http://localhost:8089/passengers")
public interface PassengerProxy {

    @GetMapping("/passport-no/{passport_no}")
    Passenger getPassengerByPassenger_no(@PathVariable String passport_no);

    @GetMapping("/{passenger_id}")
    Passenger getPassenger(@PathVariable Long passenger_id);
}
