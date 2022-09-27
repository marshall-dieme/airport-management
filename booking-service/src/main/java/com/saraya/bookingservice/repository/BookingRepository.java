package com.saraya.bookingservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.bookingservice.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
