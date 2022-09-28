package com.saraya.Rentalsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Rentals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rental_id;

    private Long passenger_id;


    private String name;

    @Column(unique = true)
    private String email;

    private String contact;

    @Column(unique = true)
    private String licence_no;

    @Column(columnDefinition = "date")
    private LocalDate pickup_date = LocalDate.now();

    @Column(columnDefinition = "time")
    private LocalTime pickup_time = LocalTime.now();

    @Column(columnDefinition = "date")
    private LocalDate return_date;

    @Column(columnDefinition = "time")
    private LocalTime return_time;

    private String car_no;

    private double amount;
}
