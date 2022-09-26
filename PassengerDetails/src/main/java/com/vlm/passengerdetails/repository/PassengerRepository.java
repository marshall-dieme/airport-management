package com.vlm.passengerdetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlm.passengerdetails.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

	List<Passenger> findByZip(String zip);

}
