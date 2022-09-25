package com.saraya.EmployeeServicesRelationshipservice.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long employee_id;
    private String firstname;
    private String lastname;
    private String services_name;
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
