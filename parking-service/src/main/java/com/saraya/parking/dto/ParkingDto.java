package com.saraya.parking.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ParkingDto {

    private Long parking_id;
    private String name;
    private String email;
    private int contact;
    private String entry_date;
    private String entry_time;
    private String exit_date;
    private String exit_time;
    private String car_no;
    private double amount;
    private String passport_no;
}
