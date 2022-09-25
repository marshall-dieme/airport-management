package com.spring.passengersservices.repository;


import com.spring.passengersservices.bean.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger,Integer> {
}
