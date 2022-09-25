package com.saraya.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.parking.bean.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long>{

}
