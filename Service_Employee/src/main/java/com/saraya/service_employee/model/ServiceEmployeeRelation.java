package com.saraya.service_employee.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import javax.persistence.GenerationType;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceEmployeeRelation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long service_id;
    private long employee_id;
}
