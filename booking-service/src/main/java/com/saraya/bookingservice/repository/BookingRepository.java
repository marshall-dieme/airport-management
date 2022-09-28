package com.saraya.bookingservice.repository;

import com.saraya.bookingservice.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel , Integer> {
    BookingModel findBySeat(String seat);
}
