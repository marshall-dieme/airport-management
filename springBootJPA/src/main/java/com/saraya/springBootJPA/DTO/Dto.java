package com.saraya.springBootJPA.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Dto {
	
	@Size(min = 5 , message="At least 5 chars")
	@NotBlank
	private String name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
