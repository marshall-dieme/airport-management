package com.saraya.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.booking.bean.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
