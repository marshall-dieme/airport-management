package com.saraya.PassengerDetailsservice.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PassengerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passenger_details_id;
    private Long passenger_id;

    @Column(columnDefinition = "date")
    private LocalDate birthdate;
    private String sex;
    private String street;
    private String city;
    private String country;
    private int zip;
    private String email;

    @Column(unique = true)
    private String telephone;
}
