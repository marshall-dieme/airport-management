package com.airport_geo.entities;

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
public class Airport_Geo {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long airport_geo_id;
	
	private String country;

	private String city;
}
