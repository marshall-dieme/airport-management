package com.saraya.employeeservice.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;

    private String firstName;

    private String lastName;

    @Column(columnDefinition = "date")
    private LocalDate hireDate;

    private Double salary;

    private String sex;

    private String street;
}
