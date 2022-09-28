package com.saraya.Rentalsservice.bean;

import lombok.Data;

@Data
public class Passenger {
    private Long passenger_id;
    private String passport_no;
    private String firstname;
    private String lastname;
}
