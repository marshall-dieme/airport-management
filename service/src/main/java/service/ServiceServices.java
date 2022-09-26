package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Services;
import repo.ServiceRepo;

@Service
public class ServiceServices {
	private final ServiceRepo repo;

	public ServiceServices(ServiceRepo repo) {
		this.repo = repo;
	}
	
	public List<Services>getAll(){
		return repo.findAll();
	}
	public Services getBYName(String services_name) {
		return repo.getBYName(services_name);
	}
	public Services create(Services services) {
		return repo.save(services);
	}
  public Services update(Services services) {
	  return repo.save(services);
  }
  public void delete(Services services) {
	   repo.delete(services);
  }
  public void deleteById(long services_id) {
	  repo.deleteById( services_id);
  }
}
