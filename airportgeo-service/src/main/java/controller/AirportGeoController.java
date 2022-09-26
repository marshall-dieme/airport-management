package controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Airport_Geo;
import service.AirportgeoService;

@RestController
@RequestMapping("/aiport_geo")
public class AirportGeoController {
	private final AirportgeoService service;

	public AirportGeoController(AirportgeoService service) {
		
		this.service = service;
	}
	@GetMapping
	public List<Airport_Geo>getAll(){
		return service.getAll();
	}
	@GetMapping()
	public Airport_Geo getById(@PathVariable long airport_geo_id) {
		return service.getById(airport_geo_id);
		
	}
	@PostMapping("/create")
	public Airport_Geo create(@RequestBody Airport_Geo airport_geo) {
		return service.create(airport_geo);
	}
	@PutMapping("/")
	public Airport_Geo update(@RequestBody Airport_Geo airport_geo) {
		return service.update(airport_geo);
	}
	@DeleteMapping("/{airport_geo_id}")
	public void deleteById(@PathVariable long airport_geo_id) {
		service.getById(airport_geo_id);
	}

}
