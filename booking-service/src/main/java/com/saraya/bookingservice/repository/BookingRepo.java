package com.saraya.bookingservice.repository;

import com.saraya.bookingservice.bean.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
    Booking findByPrice(int price);
}
