package com.saraya.Parkingservice.repository;

import com.saraya.Parkingservice.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    @Query("select p from Parking p where p.parking_id = ?1")
    Parking findByParking_id(Long parking_id);
}
