package com.saraya.EmployeeServicesRelationshipservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeServicesDto implements Serializable {
    private Long emp_service_id;
    private Long employee_id;
    private Long services_id;
}
