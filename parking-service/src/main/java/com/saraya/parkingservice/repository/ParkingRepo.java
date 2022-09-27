package com.saraya.parkingservice.repository;

import com.saraya.parkingservice.bean.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepo extends JpaRepository<Parking, Integer> {
    Parking findByName(String name);
}
