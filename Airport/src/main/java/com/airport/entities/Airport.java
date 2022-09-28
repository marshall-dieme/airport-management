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
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long airport_id;
	
	private String iata;
	
	private String icao;
	
	private String airport_name;

}
