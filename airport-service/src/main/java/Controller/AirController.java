package Controller;

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

import model.Airport;
import service.AirService;

@RestController
@RequestMapping("/airport")
public class AirController {

	private final AirService service;

	public AirController(AirService service) {
		this.service = service;
	}
	@GetMapping("/")
	public List<Airport>getAll(){
		return service.getAll();
	}

	@PostMapping("/")
	public Airport create (@RequestBody Airport airport) {
		return service.Create(airport);

}
	@PutMapping("/")
	
	public Airport update (@RequestBody Airport airport) {
		return service.Update(airport);

}
	
	@DeleteMapping("delate/{id}")
	public void deleteAll(@PathVariable Long id) {
		service.delete(id);
	}
}
