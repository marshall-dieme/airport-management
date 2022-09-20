package com.saraya.Employeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;
    private String firstname;
    private String lastname;

    @Column(columnDefinition = "date")
    private LocalDate birthdate;
    private Gender sex;
    private String email;
    private String telephone;
    private double salary;
    private String street;
    private String city;
    private String country;
    private String zip;

    @Column(unique = true)
    private String username;
    private String password;

}
