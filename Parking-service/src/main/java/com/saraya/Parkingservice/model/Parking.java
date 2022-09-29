package com.saraya.Parkingservice.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parking_id;
    private Long passenger_id;
    private String name;

    @Column(unique = true)
    private String email;
    private String country;

    private String car_no;
    private double amount;

    @Column(columnDefinition = "date")
    private LocalDate entry_date = LocalDate.now();

    @Column(columnDefinition = "date")
    private LocalDate exit_date;

    @Column(columnDefinition = "time")
    private LocalTime entry_time = LocalTime.now();

    @Column(columnDefinition = "time")
    private LocalTime exit_time;




}
