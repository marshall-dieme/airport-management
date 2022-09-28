package com.saraya.PassengerDetailsservice.service;

import com.saraya.PassengerDetailsservice.bean.ResponsePassengerWithDetails;
import com.saraya.PassengerDetailsservice.dto.PassengerDetailsDto;
import com.saraya.PassengerDetailsservice.model.PassengerDetails;
import com.saraya.PassengerDetailsservice.proxies.PassengerProxy;
import com.saraya.PassengerDetailsservice.repository.PassengerDetailsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class PassengerDetailService {

    private final PassengerDetailsRepo repo;

    private final PassengerProxy passengerProxy;
    private final ModelMapper modelMapper;

    public List<PassengerDetailsDto> getAllPassengerDetails() {
        log.info("Get All Passengers");
        return repo.findAll()
                .stream().map(passengerDetails -> modelMapper.map(passengerDetails, PassengerDetailsDto.class))
                .toList();
    }

    public PassengerDetails getPassengerDetails(Long passenger_details_id) {
        log.info("Get details Passenger");
        return repo.findById(passenger_details_id).orElseThrow();

    }

    public ResponsePassengerWithDetails getPassengerWithAllDetails(Long passenger_details_id) {
        ResponsePassengerWithDetails response =  new ResponsePassengerWithDetails();
        response.setPassenger(passengerProxy.getPassenger(
                repo.findPassengerByPassenger_details_id(passenger_details_id).getPassenger_id()));
        response.setPassengerDetails(repo.findPassengerByPassenger_details_id(passenger_details_id));

        return response;
    }

    public PassengerDetails savePassengerDetails(PassengerDetailsDto dto) {
        PassengerDetails details = getPassengerDetails(dto);
        log.info("New Passenger with details: {}", details.toString());
        return repo.save(details);
    }

    public PassengerDetails updatePassengerDetails(PassengerDetailsDto dto) {
        PassengerDetails details = getPassengerDetails(dto);
        return repo.save(details);
    }

    public void deletePassengerDetails(Long passenger_details_id) {
        repo.deleteById(passenger_details_id);
    }

    private PassengerDetails getPassengerDetails(PassengerDetailsDto dto) {
        PassengerDetails details = modelMapper.map(dto, PassengerDetails.class);
        details.setPassenger_id(passengerProxy.getPassengerByPassenger_no(dto.getPassport_no()).getPassenger_id());
        return details;
    }

}
