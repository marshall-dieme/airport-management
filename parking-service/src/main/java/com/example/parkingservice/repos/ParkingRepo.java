package com.example.parkingservice.repos;

import com.example.parkingservice.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepo extends JpaRepository<Parking ,Long> {
    List<Parking> findByPassengerId(Long passengerId);
}
