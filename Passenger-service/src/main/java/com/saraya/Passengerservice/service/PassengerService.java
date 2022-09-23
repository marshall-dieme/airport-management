package com.saraya.Passengerservice.service;

import com.saraya.Passengerservice.model.Passenger;
import com.saraya.Passengerservice.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PassengerService {

    private final PassengerRepository repository;

    public List<Passenger> getAllPassengers() {
        return repository.findAll();
    }

    public Passenger getPassenger(Long passenger_id) {
        return repository.findById(passenger_id).orElse(null);
    }

    public Passenger savePassenger(Passenger passenger) {
        return repository.save(passenger);
    }

    public Passenger updatePassenger(Passenger passenger) {
        return repository.save(passenger);
    }

    public void deletePassenger(Long passenger_id) {
        repository.deleteById(passenger_id);
    }

    public Passenger getPassengerByPassenger_no(String passport_no) {
        return repository.findByPassport_no(passport_no);
    }

    public Passenger getPassengerByFirstnameAndLastname(String firstname, String lastname) {
        return repository.findPassengerByFirstnameAndLastname(firstname, lastname);
    }
}
