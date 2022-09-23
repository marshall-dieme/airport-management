package com.saraya.Parkingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParkingDto implements Serializable {
    private Long parking_id;
    private String passport_no;
    private String name;
    private String passenger_firstname;
    private String passenger_lastname;
    private String email;
    private String country;
    private String car_no;
    private double amount;
    private String exit_date;
    private String exit_time;
}
