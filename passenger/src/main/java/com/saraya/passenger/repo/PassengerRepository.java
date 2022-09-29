package com.saraya.passenger.repo;

import com.saraya.passenger.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Double> {

 public Double getIdPassengerByPassport_noAndFirstnameAndLastname(String passport_no, String firstname, String lastname);

   public void deleteByPassport_noAndFirstnameAndLastname(String passport_no, String firstname, String lastname);
}
