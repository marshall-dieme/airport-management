package com.saraya.Airplane.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter
public class Airplane implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplane_id;
    private String  capacity;


    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = false)
    @JoinColumn(name = "airplane_type_id")
    private AirplaneType airplaneType;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = false)
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = false)
    @JoinColumn(name = "flight_id")
    private Flight flight;
}