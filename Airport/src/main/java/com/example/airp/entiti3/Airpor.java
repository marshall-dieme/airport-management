package com.example.airp.entiti3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="airports")
@Data 
@NoArgsConstructor
@AllArgsConstructor 
 @ToString
public class Airpor {
	
	/*public class Service {*/
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

		@Column(name="airport_id")
	private long airport_id;
		@Column(name="iata")
	private String iata;
		@Column(name="icao")
		private String icao;
		@Column(name="airport_name")
		private String airport_name;



	}

