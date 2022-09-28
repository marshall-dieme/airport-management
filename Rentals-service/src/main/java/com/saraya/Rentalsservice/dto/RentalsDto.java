package com.saraya.Rentalsservice.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A DTO for the {@link com.saraya.Rentalsservice.model.Rentals} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RentalsDto implements Serializable {
    private Long rental_id;
    private String name;
    private String email;
    private String contact;
    private String licence_no;
    private String return_date;
    private String return_time;
    private String car_no;
    private double amount;
    private String passport_no;
}