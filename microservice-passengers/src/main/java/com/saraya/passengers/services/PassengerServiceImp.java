package com.saraya.passengers.services;

import com.saraya.passengers.exceptions.ResourceNotFoundException;
import com.saraya.passengers.models.Passenger;
import com.saraya.passengers.repositories.PassengerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerServiceImp implements PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerServiceImp(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger add(Passenger passenger) {
        return this.passengerRepository.save(passenger);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return this.passengerRepository.save(passenger);
    }

    @Override
    public Passenger getPassenger(Long passenger_id) throws ResourceNotFoundException {
        Optional<Passenger> passenger = this.passengerRepository.findById(passenger_id);
        if (!passenger.isPresent())
            throw new ResourceNotFoundException("Passenger not available");
        return passenger.get();
    }

    @Override
    public Page<Passenger> getPassengers(Pageable pageable) {
        return this.passengerRepository.findAll(pageable);
    }

    @Override
    public void delete(Long passenger_id) throws ResourceNotFoundException {
      if (!this.existPassenger(passenger_id))
          throw new ResourceNotFoundException("impossible to remove this Passenger");

      this.passengerRepository.deleteById(passenger_id);
    }

    @Override
    public boolean existPassenger(Long passenger_id) {
        return this.passengerRepository.existsById(passenger_id);
    }
}
