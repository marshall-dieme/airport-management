package com.saraya.passengerdetails.repositories;

import com.saraya.passengerdetails.models.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails,Long> {
}
