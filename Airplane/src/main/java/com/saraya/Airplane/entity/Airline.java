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
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long airline_id;
   private String airline_name;
   private String iata;
}