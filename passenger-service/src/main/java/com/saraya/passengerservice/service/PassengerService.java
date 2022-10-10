package com.saraya.passengerservice.service;

import com.saraya.passengerservice.bean.Passenger;
import com.saraya.passengerservice.dto.PassengerDto;
import com.saraya.passengerservice.mapper.PassengerMapper;
import com.saraya.passengerservice.repository.PassengerRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    private PassengerMapper mapper = new PassengerMapper();

    public int getId(String passportNo) {
        return repo.findByPassportNo(passportNo).getId();
    }

    public Passenger create(PassengerDto dto) {
        return repo.save(mapper.toEntity(dto));
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
        int parckingId = restTemplate.getForEntity("http://localhost:8012/Parking/"+parkingName, Integer.class).getBody();
        passenger.setParckingId(parckingId);

        return repo.save(passenger);
    }

    public Passenger putRentalsForRentals(int passengerId, String rentalsName) {

        Passenger passenger = repo.findById(passengerId).get();

        RestTemplate restTemplate = new RestTemplate();
        int rentalsId = restTemplate.getForEntity("http://localhost:8013/Rentals/"+rentalsName, Integer.class).getBody();
        passenger.setRentalsId(rentalsId);

        return repo.save(passenger);
    }

    public Passenger putPassengerDetailsForPassenger(int passengerId, String emailPassengerDetail) {

        Passenger passenger = repo.findById(passengerId).get();

        RestTemplate restTemplate = new RestTemplate();
        int passengerDetailsId = restTemplate.getForEntity("http://localhost:8011/PassengerDetails/"+emailPassengerDetail, Integer.class).getBody();
        passenger.setPassengerDetailsId(passengerDetailsId);

        return repo.save(passenger);
    }

    @PutMapping
    public Passenger update(@RequestBody PassengerDto dto) {
        return repo.save(mapper.toEntity(dto));
    }

    @GetMapping
    public void delete(@RequestBody PassengerDto dto) {
        repo.delete(mapper.toEntity(dto));
    }
}
