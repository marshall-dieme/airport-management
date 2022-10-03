package com.saraya.microservicebookings.mappers;

import com.saraya.microservicebookings.dto.BookingDto;
import com.saraya.microservicebookings.models.Booking;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookingMapper {
    Booking bookingDtoToBooking(BookingDto bookingDto);

    BookingDto bookingToBookingDto(Booking booking);

    List<BookingDto> bookingsToBookingDtos(List<Booking> bookings);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Booking updateBookingFromBookingDto(BookingDto bookingDto, @MappingTarget Booking booking);
}
