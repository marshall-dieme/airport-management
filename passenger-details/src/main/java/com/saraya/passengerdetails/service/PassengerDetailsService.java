package com.saraya.passengerdetails.service;

import com.saraya.passengerdetails.bean.PassengerDetails;
import com.saraya.passengerdetails.dto.PassengerDetailsDto;
import com.saraya.passengerdetails.repository.PassengerDetailsRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PassengerDetailsService {
    private final PassengerDetailsRepo repo;

    public PassengerDetailsService(PassengerDetailsRepo repo) {
        this.repo = repo;
    }

    public List<PassengerDetails> getAll() {
        return repo.findAll();
    }

    public int getId(String emailPassengerDetails) {
        return repo.findByEmail(emailPassengerDetails).getId();
    }

    public PassengerDetails create(PassengerDetailsDto dto) {
        return repo.save(toEntity(dto));
    }

    private PassengerDetails toEntity(PassengerDetailsDto dto) {
        PassengerDetails passengerDetails = new PassengerDetails();
        passengerDetails.setEmail(dto.getEmail());
        passengerDetails.setTelephone(dto.getTelephone());
        return passengerDetails;
    }


    public PassengerDetails putPassengerForPassengerDetails(int passengerDetailsId, String passportNo) {

        PassengerDetails passengerDetails = repo.findById(passengerDetailsId).get();

        RestTemplate restTemplate = new RestTemplate();
        int passengerId = restTemplate.getForEntity("http://localhost:8010/Passenger/"+passportNo, Integer.class).getBody();
        passengerDetails.setPassengerId(passengerId);

        return repo.save(passengerDetails);
    }
}
