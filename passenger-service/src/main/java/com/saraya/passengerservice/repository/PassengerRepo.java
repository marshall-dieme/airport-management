package com.saraya.passengerservice.repository;

import com.saraya.passengerservice.bean.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Integer> {

    Passenger findByPassportNo(String numberPassport);
}
