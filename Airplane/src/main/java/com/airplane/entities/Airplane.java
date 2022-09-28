package com.airplane.entities;

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
public class Airplane {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long airplane_id;
	
	private int capacity;

}
