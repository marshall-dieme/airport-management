package com.saraya.microserviceparkings.services;

import com.saraya.microserviceparkings.exceptions.ResourceNotFoundException;
import com.saraya.microserviceparkings.models.Parking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ParkingService {

    Parking add(Parking parking) throws ResourceNotFoundException;
    Parking update(Parking parking) throws ResourceNotFoundException;
    Parking getParking(Long parking_id) throws ResourceNotFoundException;
    Page<Parking> getParkings(Pageable pageable);
    void delete(Long parking_id) throws ResourceNotFoundException;
    boolean existParking(Long parking_id);

}
