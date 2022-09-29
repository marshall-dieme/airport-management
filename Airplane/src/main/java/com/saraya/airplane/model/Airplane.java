package com.saraya.airplane.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long airplane_id;
    private String airplane_capacity;
    private long airline_id;
    private long airplane_type_id;
    private long flight_id;

}
