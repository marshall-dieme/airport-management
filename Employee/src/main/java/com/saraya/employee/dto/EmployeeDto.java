package com.saraya.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private long employee_id;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String sex;
    private String street;
    private String city;
    private String zip;
    private String country;
    private String email;
    private long telephone;
    private Double salary;
    private String username;
    private String password;
    private long service_id;



}
