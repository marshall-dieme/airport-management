package com.spring.passengersdetails.repository;


import com.spring.passengersdetails.bean.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDetailsRepo extends JpaRepository<PassengerDetails,Integer> {

}
