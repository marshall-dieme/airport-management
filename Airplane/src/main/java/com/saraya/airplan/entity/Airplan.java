package com.saraya.airplan.entity;

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
@Table(name="airplanes")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Airplan {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name= "airplan_id")
    private Long airplane_id;
	@Column(name= "capacity")
    private int capacity;
	
}
