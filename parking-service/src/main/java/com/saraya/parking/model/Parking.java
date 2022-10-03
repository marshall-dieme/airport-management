package com.saraya.parking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parking_id;

    private Long passenger_id;
    private String name;
    private String email;
    private int contact;
    private LocalDate entry_date;
    private LocalTime entry_time;
    private LocalDate exit_date;
    private LocalTime exit_time;
    private String car_no;
    private double amount;
}
