package com.saraya.passengerdetails.dto;

import lombok.Data;


@Data
public class PassengerDetailsDto {
    private Long passenger_details_id;
    private String birthdate;
    private String sex;
    private String street;
    private String city;
    private String zip;
    private String country;
    private String email;
    private String passport_no;
    private int telephone;
}
