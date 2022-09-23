package com.saraya.passenger.repository;

import com.saraya.passenger.bean.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger,Integer> {
    Passenger findByPassengerId(int id);
}
