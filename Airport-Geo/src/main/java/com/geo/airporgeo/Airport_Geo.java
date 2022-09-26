package com.geo.airporgeo;
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
@Table(name="airports_geo")
@Data 
@NoArgsConstructor
@AllArgsConstructor 
 @ToString
public class Airport_Geo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="airport_geo_id")
private long airport_id;
	@Column(name="country")
private String country;
	@Column(name="city")
	private String city;
	

}
