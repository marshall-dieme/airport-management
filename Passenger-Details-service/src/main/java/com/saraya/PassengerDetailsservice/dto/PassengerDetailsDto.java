package com.saraya.PassengerDetailsservice.dto;

import lombok.*;

import java.io.Serializable;

@Data
public class PassengerDetailsDto implements Serializable {
    private Long passenger_details_id;
    private String passport_no;
    private String birthdate;
    private String sex;
    private String street;
    private String city;
    private String country;
    private int zip;
    private String email;
    private String telephone;

}
