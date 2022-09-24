package com.saraya.service_employee.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GenerationType;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceEmployeeRelation {


    @Id
    @GeneratedValue(value = ValueGenerationType.IDENTIFY)
    private int id;
    private long service_id;
    private long employee_id;
}
