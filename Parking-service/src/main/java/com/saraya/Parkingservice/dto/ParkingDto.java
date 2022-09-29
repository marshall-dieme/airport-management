package com.saraya.Parkingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParkingDto implements Serializable {
    private Long parking_id;
    private String passport_no;
    private String name;
    private String email;
    private String country;
    private double amount;
    private String car_no;
    private String exit_date;
    private String exit_time;
}
