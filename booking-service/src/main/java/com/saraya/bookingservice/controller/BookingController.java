package com.saraya.bookingservice.controller;

import com.saraya.bookingservice.model.BookingModel;
import com.saraya.bookingservice.model.BookingModelDTO;
import com.saraya.bookingservice.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookingModel> getAll(){
        return service.getAll();
    }

    @GetMapping("/recup/{seat}")
    public BookingModel getBySeat(
            @PathVariable String seat){
        return service.getBySeat(seat);
    }

    @PostMapping
    public BookingModel create(@RequestBody BookingModel bookingModel){
        LOGGER.info("CREATING a NEW BOOKING...");
        return service.create(bookingModel);
    }

    @PutMapping
    public BookingModel update(@RequestBody BookingModel bookingModel){
        LOGGER.info("Update A BOOKING....");
        return service.update(bookingModel);
    }

    @DeleteMapping("delete/{seat}")
    public void deleteBySeat(
            @PathVariable String seat){
        service.deleteBySeat(seat);
    }

    @DeleteMapping("/{bookingId}")
    public void deleteById(@PathVariable int bookingId){
        service.deleteById(bookingId);
    }

}
