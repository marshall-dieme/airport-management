package com.saraya.entit;

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
@Table(name="airline")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Airlin {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="airline_id")
	private Long airline_id;
	private String airline_name;
	private String iata;
}
