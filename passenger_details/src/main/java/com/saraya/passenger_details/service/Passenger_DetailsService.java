package com.saraya.passenger_details.service;

import com.saraya.passenger_details.bean.Passenger;
import com.saraya.passenger_details.dtos.Passenger_DetailsDto;
import com.saraya.passenger_details.model.PassengerDetails;
import com.saraya.passenger_details.proxy.PassengerProxy;
import com.saraya.passenger_details.repository.Passenger_DetailsRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class Passenger_DetailsService {

    private final PassengerProxy passengerProxy;
    private final Passenger_DetailsRepo repo;

    private final ModelMapper modelMapper;



    public List<PassengerDetails> getAll() {
        return repo.findAll();
    }

    public PassengerDetails getById(Long id) {
        return repo.findById(id).get();
    }

    public PassengerDetails create(Passenger_DetailsDto dto) {
        PassengerDetails details = modelMapper.map(dto,PassengerDetails.class);
        Passenger passenger = passengerProxy.getPassengerByPassenger_no(dto.getPassport_no());
        details.setPassenger_id(passenger.getPassenger_id());
        return repo.save(details);
    }


    public PassengerDetails update(PassengerDetails passengerDetails) {
        return repo.save(passengerDetails);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


}
