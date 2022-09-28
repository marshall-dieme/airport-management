package com.saraya.passenger_details.proxy;

import com.saraya.passenger_details.bean.Passenger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "passenger-service", url = "http://localhost:8087/Passengers")
public interface PassengerProxy {
    @GetMapping("/Passport-no/{Passport_no}")
    Passenger getPassengerByPassenger_no(@PathVariable String Passport_no) ;

    @GetMapping("/{Passenger_id}")
    Passenger getPassenger(@PathVariable Long Passenger_id) ;


}
