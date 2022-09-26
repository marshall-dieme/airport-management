package com.vlm.airport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Airportt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long airport_id;
	
	@Column(name = "iata")
	private String iata;
	
	@Column(name = "icao")
	private String icao;
	
	@Column(name = "airport_name")
	private String airport_name;
	
	public Airportt() {
		
	}
	
		public Airportt(String iata, String icao, String airport_name) {
		super();
		this.iata = iata;
		this.icao = icao;
		this.airport_name = airport_name;
	}
		
		public Long getAirport_id() {
			return airport_id;
		}
		public void setAirport_id(Long airport_id) {
			this.airport_id = airport_id;
		}
		public String getIata() {
			return iata;
		}
		public void setIata(String iata) {
			this.iata = iata;
		}
		public String getIcao() {
			return icao;
		}
		public void setIcao(String icao) {
			this.icao = icao;
		}
		public String getAirport_name() {
			return airport_name;
		}
		public void setAirport_name(String airport_name) {
			this.airport_name = airport_name;
		}

}
