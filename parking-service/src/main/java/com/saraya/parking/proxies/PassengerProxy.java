package com.saraya.parking.proxies;

import com.saraya.parking.bean.Passenger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "passenger-service", url = "http://localhost:8087/passenger")
public interface PassengerProxy {

    @GetMapping("/passport-no/{passport_no}")
    Passenger getPassenger(@PathVariable String passport_no);


}
