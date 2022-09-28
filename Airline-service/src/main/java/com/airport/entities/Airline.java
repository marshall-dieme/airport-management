package com.airport.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long airline_id;
	
	private String airline_name;
	
	private String iata;


}
