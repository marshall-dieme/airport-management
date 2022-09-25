package com.saraya.Employeeservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDto implements Serializable {
    private Long employee_id;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String sex;
    private String email;
    private String telephone;
    private double salary;
    private String street;
    private String city;
    private String country;
    private int zip;
    private String username;
    private String password;
}
