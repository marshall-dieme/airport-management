package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Services;
@Repository
public interface ServiceRepo extends JpaRepository<Services, Long>{
	@Query("SELECT  s FROM Department d WHERE s.servics_name=:services_name")

	Services getBYName(String services_name);
	
	
}
