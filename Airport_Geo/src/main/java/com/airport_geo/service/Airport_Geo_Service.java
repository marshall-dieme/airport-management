package com.airport_geo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport_geo.dao.Airport_Geo_Dao;
import com.airport_geo.entities.Airport_Geo;

@Service
public class Airport_Geo_Service {
	@Autowired Airport_Geo_Dao airport_Geo_Dao;
	
	public List<Airport_Geo> getAll(){
		return airport_Geo_Dao.findAll();
	}
	public Airport_Geo getById(long id) {
		return airport_Geo_Dao.getById(id);
	}
	public Airport_Geo create(Airport_Geo airport_Geo) {
		return airport_Geo_Dao.save(airport_Geo);
	}
	public Airport_Geo update(Airport_Geo airport_Geo) {
		return airport_Geo_Dao.save(airport_Geo);
	}
	public void delete(long id) {
		airport_Geo_Dao.deleteById(id);
	}

}
