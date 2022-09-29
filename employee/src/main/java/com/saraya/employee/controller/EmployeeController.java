package com.saraya.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController<AirportService> {

    private final AirportService service;

    public EmployeeController(AirportService service) {
        this.service = service;
    }
}
