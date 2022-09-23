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

    private static int number = 1;
    private final PassengerRepository repository;

    public List<Passenger> getAllPassengers() {
        return repository.findAll();
    }

    public Passenger getPassenger(Long passenger_id) {
        return repository.findById(passenger_id).orElse(null);
    }

    public Passenger savePassenger(Passenger passenger) {
        passenger.setPassenger_no(generatePassengerNo());
        return repository.save(passenger);
    }

    public Passenger updatePassenger(Passenger passenger) {
        return repository.save(passenger);
    }

    public void deletePassenger(Long passenger_id) {
        repository.deleteById(passenger_id);
    }

    public Passenger getPassengerByPassenger_no(String passenger_no) {
        return repository.findByPassenger_no(passenger_no);
    }


    /******** Generate Passenger number****/
    private String generatePassengerNo() {
        return "EMP_NO-"+ number++;
    }

    /******** RestTemplate to communicate others services **********/
    public void getDetailsByRestTemplate(){
        Map<String, String> booking_value = new HashMap<>();


        Map<String, String> parking_value = new HashMap<>();


        Map<String, String> rentals_value = new HashMap<>();

    }
}
