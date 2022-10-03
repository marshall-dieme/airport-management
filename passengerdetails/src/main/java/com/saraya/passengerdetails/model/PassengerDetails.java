package com.saraya.passengerdetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passenger_details_id;


    private Long passenger_id;
    private LocalDate birthdate;
    private String sex;
    private String street;
    private String city;
    private String zip;
    private String country;
    private String email;
    private int telephone;
}
