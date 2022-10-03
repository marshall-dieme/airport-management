package com.saraya.passengerdetails.repository;

import com.saraya.passengerdetails.model.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, Long> {
}
