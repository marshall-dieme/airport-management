package com.saraya.airline.model;

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
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long airline_id;
    private String airline_name;
    private String iata;
    private long airport_id;

}
