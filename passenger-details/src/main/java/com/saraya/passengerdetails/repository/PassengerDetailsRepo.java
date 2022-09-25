package com.saraya.passengerdetails.repository;

import com.saraya.passengerdetails.bean.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDetailsRepo extends JpaRepository<PassengerDetails, Integer> {
     PassengerDetails findByEmail(String email);
}
