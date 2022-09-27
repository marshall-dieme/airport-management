package com.saraya.Airplane.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class AirplaneToFlight {
    
     
    private Long airplane_id;
     private String  capacity;
     private String flight_no;
     private LocalDate  departure_date;
     private LocalDate  arrival_date;
     private String  from;
     private String  to;
}