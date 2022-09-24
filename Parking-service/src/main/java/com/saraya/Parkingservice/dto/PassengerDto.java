package com.saraya.Parkingservice.dto;

import lombok.Data;

@Data
public class PassengerDto {
    private long passenger_id;
    private String passport_no;
    private String firstname;
    private String lastname;
}
