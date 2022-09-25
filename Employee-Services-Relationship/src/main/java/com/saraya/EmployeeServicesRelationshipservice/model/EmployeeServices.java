package com.saraya.EmployeeServicesRelationshipservice.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class EmployeeServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emp_service_id;

    @Column(unique = true)
    private Long employee_id;

    @Column(unique = true)
    private Long services_id;
}
