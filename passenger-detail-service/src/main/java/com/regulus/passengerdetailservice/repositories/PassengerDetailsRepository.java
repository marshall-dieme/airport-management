package com.regulus.passengerdetailservice.repositories;

import com.regulus.passengerdetailservice.models.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, Integer> {

}
