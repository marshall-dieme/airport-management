package com.saraya.employee.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TableTimeFlight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tabletimeflight_id;
	private Long time_table_id;
	private Long flight_id;
	public TableTimeFlight() {
		super();
	}
	public Long getTabletimeflight_id() {
		return tabletimeflight_id;
	}
	public void setTabletimeflight_id(Long tabletimeflight_id) {
		this.tabletimeflight_id = tabletimeflight_id;
	}
	public Long getTime_table_id() {
		return time_table_id;
	}
	public void setTime_table_id(Long time_table_id) {
		this.time_table_id = time_table_id;
	}
	public Long getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(Long flight_id) {
		this.flight_id = flight_id;
	}
	
}
