package com.regulus.parkingservice.repositories;

import com.regulus.parkingservice.models.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {

    @Query("select b.parking_id from Parking b where b.name=:name")
    Integer findByName(String name);
}
