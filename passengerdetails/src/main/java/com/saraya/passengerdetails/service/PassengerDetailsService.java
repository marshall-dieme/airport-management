package com.saraya.passengerdetails.service;

import com.saraya.passengerdetails.bean.Passenger;
import com.saraya.passengerdetails.dto.PassengerDetailsDto;
import com.saraya.passengerdetails.model.PassengerDetails;
import com.saraya.passengerdetails.proxies.PassengerProxy;
import com.saraya.passengerdetails.repository.PassengerDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerDetailsService {

    @Autowired
    private PassengerDetailsRepository repo;
    @Autowired
    private PassengerProxy passengerProxy;

    @Autowired
    private ModelMapper mapper;

    public List<PassengerDetails> getAllPassengerDetails(){
        return repo.findAll();
    }

    public PassengerDetails getByIdPassengerDetails(Long passenger_details_id){
        return repo.findById(passenger_details_id).get();
    }

    public PassengerDetails createPassengerDetails(PassengerDetailsDto passengerDetailsDto){
        PassengerDetails details = getPassengerDetails(passengerDetailsDto);
        return repo.save(details);
    }



    public PassengerDetails updatePassengerDetails(PassengerDetailsDto passengerDetailsDto){
        PassengerDetails details = getPassengerDetails(passengerDetailsDto);
        return repo.save(details);
    }
    public void deletePassengerDetails(Long passenger_details_id ){
        repo.deleteById(passenger_details_id);
    }

    private PassengerDetails getPassengerDetails(PassengerDetailsDto passengerDetailsDto) {
        Passenger passenger = passengerProxy.getPassenger(passengerDetailsDto.getPassport_no());
        PassengerDetails details = mapper.map(passengerDetailsDto, PassengerDetails.class);
        details.setPassenger_id(passenger.getPassenger_id());
        return details;
    }
}
