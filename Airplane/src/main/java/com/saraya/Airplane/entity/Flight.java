package com.saraya.Airplane.entity;

import java.io.Serializable;
import java.time.LocalDate;

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
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flight_id;
    private String flight_no;
    private LocalDate  departure_date;
    private LocalDate  arrival_date;
    private String  from;
    private String  to;
}