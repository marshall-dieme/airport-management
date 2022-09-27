package com.saraya.PassengerDetailsservice.repository;

import com.saraya.PassengerDetailsservice.model.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDetailsRepo extends JpaRepository<PassengerDetails, Long> {
}
