package EmployeeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vlm.employee.model.Employee;
import com.vlm.employee.model.EmployeeDTO;
import com.vlm.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }
    
    public Optional<Employee> getById(Long id) {
        return repo.findById(id);
    }
    
    public Employee create(EmployeeDTO dto) {
    	Employee employee = new Employee();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("airlines", dto.getZip());
        String Zip = template.getForEntity(
                "http://localhost:8700/iata/airlines/{employees}",
                        String.class,
                        urlValues)
                        .getBody();
        changeToModel(dto, employee);
        employee.setZip(Zip);
        return repo.save(employee);
    }

	private void changeToModel(EmployeeDTO dto, Employee employee) {
		
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setBirthDate(dto.getBirthDate());
		employee.setSex(dto.getSex());
		employee.setStreet(dto.getStreet());
		employee.setCity(dto.getCity());
		employee.setZip(dto.getZip());
		employee.setCountry(dto.getCountry());
		employee.setEmail(dto.getEmail());
		employee.setUsername(dto.getUsername());
		employee.setPassword(dto.getPassword());
		
	}
	

	public void delete(Long id) {
        repo.deleteById(id);
    }
	
	public List<Employee> getByZip(String zip) {
        Map<String, String> values = new HashMap<>();
        values.put("employees", zip);
        RestTemplate template = new RestTemplate();
        String Zip = template.getForEntity("http://localhost:8700/iata/employees/{employees}",
                String.class, values).getBody();

        return repo.findByZip(Zip);
    }
	
	public Employee createWithRelation(EmployeeDTO dto) {
		Employee employee = new Employee();
        changeToModel(dto, employee);
        String Zip = new RestTemplate().getForEntity(
                "http://localhost:8700/employees/employees/"+dto.getZip(),
                String.class).getBody();
        employee = repo.save(employee);
        Map<String, String> values = new HashMap<>();
        values.put("Zip", Zip);
        values.put("Zip", String.valueOf(employee.getZip()));
        new RestTemplate().getForEntity("http://localhost:8900/relation/{Zip}/{idEmployee}",
                Void.class, values);

        return employee;
    }

}
