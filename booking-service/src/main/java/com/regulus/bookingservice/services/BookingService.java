package com.regulus.bookingservice.services;

import com.regulus.bookingservice.dtos.BookingDto;
import com.regulus.bookingservice.models.Booking;
import com.regulus.bookingservice.repositories.BookingRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingService {

    private final BookingRepository repository;

    private final Mapper mapper;

    public BookingService(BookingRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Booking> getBooking(){
        return repository.findAll();
    }

    public BookingDto getBooking(int id){
        Booking booking =  repository.findById(id).get();
        return mapper.toDto(booking);
    }

    public BookingDto createBooking(BookingDto bookingDto){
        Booking booking = mapper.toEntity(bookingDto);
        booking =  repository.save(booking);
        return mapper.toDto(booking);
    }

    public BookingDto updateBooking(BookingDto bookingDto, int id){
        BookingDto bookingDto1 = getBooking(id);
        Booking booking = mapper.toEntity(bookingDto1);
        booking.setBooking_id(bookingDto.getBooking_id());
        booking.setSeat(bookingDto.getSeat());
        booking.setPrice(bookingDto.getPrice());
        booking = repository.save(booking);
        return mapper.toDto(booking);
    }

    public void deleteBooking(int id){
        BookingDto bookingDto = getBooking(id);
        Booking booking = mapper.toEntity(bookingDto);
        repository.delete(booking);
    }

    public Integer getBookingId(int seat) {
        return repository.findBySeat(seat);
    }

}
