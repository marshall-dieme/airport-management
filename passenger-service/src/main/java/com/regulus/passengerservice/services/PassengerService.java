package com.regulus.passengerservice.services;

import com.regulus.passengerservice.dtos.PassengerDto;
import com.regulus.passengerservice.models.Passenger;
import com.regulus.passengerservice.repositories.PassengeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PassengerService {

    private final PassengeRepository repository;

    private final RestTemplate restTemplate;
    private final Mapper mapper;

    public PassengerService(PassengeRepository repository, RestTemplate restTemplate, Mapper mapper) {
        this.repository = repository;
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    public List<Passenger> getPassenger(){
        return repository.findAll();
    }

    public PassengerDto getPassenger(int id){
        Passenger passenger =  repository.findById(id).get();
        return mapper.toDto(passenger);
    }

    public PassengerDto createPassenger(PassengerDto passengerDto){
        Integer bookingId = restTemplate.getForEntity("http://booking-service/booking/seat/" + passengerDto.getBooking_seat(),
                Integer.class).getBody();
        assert  bookingId != null;
        passengerDto.setBooking_id(bookingId);
        Integer parkingId = restTemplate.getForEntity("http://parking-service/parking/name/" + passengerDto.getParking_name(),
                Integer.class).getBody();
        assert  parkingId != null;
        passengerDto.setParking_id(parkingId);
        Integer rentalId = restTemplate.getForEntity("http://rental-service/rental/name/" + passengerDto.getRental_name(),
                Integer.class).getBody();
        assert  rentalId != null;
        passengerDto.setRental_id(rentalId);
        Passenger passenger = mapper.toEntity(passengerDto);
        passenger =  repository.save(passenger);
        return mapper.toDto(passenger);
    }

    public PassengerDto updatePassenger(PassengerDto passengerDto, int id){
        PassengerDto passengerDto1 = getPassenger(id);
        Passenger passenger = mapper.toEntity(passengerDto1);
        passenger.setPassenger_id(passengerDto.getPassenger_id());
        passenger.setPassport_no(passengerDto.getPassport_no());
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setBooking_id(passengerDto.getBooking_id());
        passenger.setParking_id(passengerDto.getParking_id());
        passenger.setRental_id(passengerDto.getRental_id());
        passenger = repository.save(passenger);
        return mapper.toDto(passenger);
    }

    public void deletePassenger(int id){
        PassengerDto passengerDto = getPassenger(id);
        Passenger passenger = mapper.toEntity(passengerDto);
        repository.delete(passenger);
    }

    public Integer getPassengerId(String passport) {
        return repository.findByPassport_no(passport);
    }
}
