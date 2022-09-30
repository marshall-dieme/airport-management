package com.saraya.passengerdetails.reository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.passengerdetails.model.PassengerDetails;
@Repository
public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, Long> {
	PassengerDetails findByTelephoneAndEmail(String telephone, String email);
}
