package com.saraya.Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.Booking.model.Booking;
@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{


	

	Booking findBySeat(String seat);

	Booking findByBookingId(int bookingId);

	void deleteBySeat(String seat);

}
