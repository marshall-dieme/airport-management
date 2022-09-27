package com.saraya.passengerservice.service;

import com.saraya.passengerservice.bean.Passenger;
import com.saraya.passengerservice.dto.PassengerDto;
import com.saraya.passengerservice.repository.PassengerRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PassengerService {

    private final PassengerRepo repo;

    public PassengerService(PassengerRepo repo) {
        this.repo = repo;
    }

    public List<Passenger> getAll() {
        return repo.findAll();
    }

    public int getId(String passportNo) {
        return repo.findByPassportNo(passportNo).getId();
    }

    public Passenger create(PassengerDto dto) {
        return repo.save(toEntity(dto));
    }

    private Passenger toEntity(PassengerDto dto) {
        Passenger passenger = new Passenger();
        passenger.setFirstname(dto.getFirstname());
        passenger.setLastname(dto.getLastname());
        passenger.setPassportNo(dto.getPassportNo());
        return passenger;
    }

    public Passenger putbookingForPassenger(int passengerId, int priceBooking) {
        Passenger passenger = repo.findById(passengerId).get();

        RestTemplate restTemplate = new RestTemplate();
        int bookingId = restTemplate.getForEntity("http://localhost:8006/Booking/"+priceBooking, Integer.class).getBody();
        passenger.setBookingId(bookingId);

        return repo.save(passenger);
    }

    public Passenger putparckingForPassenger(int passengerId, String parkingName) {

        Passenger passenger = repo.findById(passengerId).get();

        RestTemplate restTemplate = new RestTemplate();
        int parckingId = restTemplate.getForEntity("http://localhost:8011/Parking/"+parkingName, Integer.class).getBody();
        passenger.setParckingId(parckingId);

        return repo.save(passenger);
    }

    public Passenger putRentalsForPassenger(int passengerId, String rentalsName) {

        Passenger passenger = repo.findById(passengerId).get();

        RestTemplate restTemplate = new RestTemplate();
        int rentalsId = restTemplate.getForEntity("http://localhost:8011/Parking/"+rentalsName, Integer.class).getBody();
        passenger.setParckingId(rentalsId);

        return repo.save(passenger);
    }

    public Passenger putPassengerDetailsForPassenger(int passengerId, String emailPassengerDetail) {

        Passenger passenger = repo.findById(passengerId).get();

        RestTemplate restTemplate = new RestTemplate();
        int passengerDetailsId = restTemplate.getForEntity("http://localhost:8011/PassengerDetail/"+emailPassengerDetail, Integer.class).getBody();
        passenger.setPassengerDetailsId(passengerDetailsId);

        return repo.save(passenger);
    }
}
