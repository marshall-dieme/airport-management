package com.saraya.microserviceparkings.repositories;


import com.saraya.microserviceparkings.models.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking,Long> {
}
