package com.saraya.passenger_details.dtos;

import lombok.Data;

@Data
public class Passenger_DetailsDto {
    private Long passengerdetails_id;

    private String sex;
    private String birthdate;

    private String street;

    private String city;

    private String zip;
    private String country;

    private String email;

    private String telephone;

    private String passport_no;

}
