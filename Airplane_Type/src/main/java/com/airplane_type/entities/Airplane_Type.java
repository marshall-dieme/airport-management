package com.airplane_type.entities;

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
public class Airplane_Type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long airplane_type_id;
	
	private String identifier;
	
	private String description;

}
