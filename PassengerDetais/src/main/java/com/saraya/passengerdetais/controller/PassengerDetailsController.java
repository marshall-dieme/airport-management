package com.saraya.passengerdetais.controller;

import com.saraya.passengerdetais.model.PassengerDetails;
import com.saraya.passengerdetais.model.PassengerDetailsDto;
import com.saraya.passengerdetais.service.PassengerDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengerDetails")
public class PassengerDetailsController {
    @Autowired
    private ModelMapper mapper;
    private  final  PassengerDetailsService service;

    public PassengerDetailsController(PassengerDetailsService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<PassengerDetails> getAll(){
        return  service.getAll();
    }

    @GetMapping("/email/{email}")
    public Long getIdPassengerDetails(@PathVariable String email){
        return service.getIdPassengerDetails(email);
    }

    @PostMapping("/")
    public PassengerDetails create(@RequestBody PassengerDetailsDto passengerDetails){
        PassengerDetails details = mapper.map(passengerDetails, PassengerDetails.class);
        return service.create(details);
    }
    @PutMapping("/")
    public  PassengerDetails update(@RequestBody PassengerDetails details){
        return service.update(details);
    }



    @DeleteMapping("/{passenger_details_id}")
    public  void  deleteById(@PathVariable Long passenger_details_id){
        service.deleteById(passenger_details_id);
    }
}
