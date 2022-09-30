package com.saraya.passagerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.passagerservice.model.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger , Integer> {

	Passenger findByPassportNo(String passportNo);

	void deleteByPassengerId(int passengerId);

	Passenger findByPassportNo(Passenger passenger);

}
