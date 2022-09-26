package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String iata;
	
	private String icao;
	
	@Column(unique=true)
	private String airport_name;

	public Airport() {
		
	}

	public Airport(long id, String iata, String icao, String airport_name) {
		this.id = id;
		this.iata = iata;
		this.icao = icao;
		this.airport_name = airport_name;
	}
	
	
	
	
	
	

}
