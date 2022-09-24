package com.saraya.passagerdetailsservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.passagerdetailsservice.model.PassagerDetails;

public interface PassagerDetailsRepo extends JpaRepository<PassagerDetails , Integer> {


	PassagerDetails findByEmail(String email);

	List<PassagerDetails> findAll();

	PassagerDetails findBypassportNo(String passportNo);

	void deleteBypassengerDetailsId(int passengerDetailsId);

}
