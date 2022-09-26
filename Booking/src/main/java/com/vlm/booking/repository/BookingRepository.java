package com.vlm.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlm.booking.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
