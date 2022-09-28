package com.saraya.parkingservice.repository;

import com.saraya.parkingservice.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParkingRepository extends JpaRepository<Parking , Integer> {

    Parking findByNameAndEmail(String name, String email);
}
