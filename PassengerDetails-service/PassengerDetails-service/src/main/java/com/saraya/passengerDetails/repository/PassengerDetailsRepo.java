package com.saraya.passengerDetails.repository;

import com.saraya.passengerDetails.bean.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDetailsRepo extends JpaRepository<PassengerDetails,Integer> {
    PassengerDetails findByPassengerDetailsId(int id);
}
