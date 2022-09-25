package com.saraya.passenger_details.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class PassengerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passengerdetails_id;

    private String sex;
    private LocalDate birthdate;

    private String street;

    private String city;

    private String zip;
    private String country;

    private String email;

    private String telephone;
}
