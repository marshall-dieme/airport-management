package com.saraya.microserviceparkings.services;

import com.saraya.microserviceparkings.exceptions.ResourceNotFoundException;
import com.saraya.microserviceparkings.models.Parking;
import com.saraya.microserviceparkings.repositories.ParkingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingServiceImp implements ParkingService {
    private final ParkingRepository parkingRepository;

    public ParkingServiceImp(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public Parking add(Parking parking) {
        return this.parkingRepository.save(parking);
    }

    @Override
    public Parking update(Parking parking) {
        return this.parkingRepository.save(parking);
    }

    @Override
    public Parking getParking(Long parking_id) throws ResourceNotFoundException {
        Optional<Parking> parking = this.parkingRepository.findById(parking_id);
        if (!parking.isPresent())
            throw new ResourceNotFoundException("Parking not available");
        return parking.get();
    }

    @Override
    public Page<Parking> getParkings(Pageable pageable) {
        return this.parkingRepository.findAll(pageable);
    }

    @Override
    public void delete(Long parking_id) throws ResourceNotFoundException {
      if (!this.existParking(parking_id))
          throw new ResourceNotFoundException("impossible to remove this Parking");

      this.parkingRepository.deleteById(parking_id);
    }

    @Override
    public boolean existParking(Long parking_id) {
        return this.parkingRepository.existsById(parking_id);
    }
}
