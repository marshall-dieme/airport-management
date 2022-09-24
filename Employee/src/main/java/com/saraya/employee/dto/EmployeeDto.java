package com.saraya.employee.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto extends AbstractDto<Long> {

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
