package com.saraya.passengerdetails.Controller;

import com.saraya.passengerdetails.bean.PassengerDetails;
import com.saraya.passengerdetails.dto.PassengerDetailsDto;
import com.saraya.passengerdetails.service.PassengerDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PassengerDetails")
public class PassengerDetailsController {

    private final PassengerDetailsService service;

    public PassengerDetailsController(PassengerDetailsService service) {
        this.service = service;
    }

    @GetMapping("/{emailPassengerDetails}")
    public int idPassenger(@PathVariable("emailPassengerDetails") String emailPassengerDetails){
        return service.getId(emailPassengerDetails);
    }

    @PostMapping("/passenger/{passengerDetailsId}/{passportNo}")
    public PassengerDetails putPassengerForPassengerDetails(@PathVariable("passengerDetailsId") int passengerDetailsId, @PathVariable("passportNo") String passportNo){
        return service.putPassengerForPassengerDetails(passengerDetailsId, passportNo);
    }

    @GetMapping
    public List<PassengerDetails> getAll(){
        return service.getAll();
    }

    @PostMapping
    public PassengerDetails create(@RequestBody PassengerDetailsDto dto){
        return service.create(dto);
    }

}
