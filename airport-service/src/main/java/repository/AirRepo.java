package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Airport;
@Repository

public interface AirRepo extends JpaRepository<Airport,Long>{
	
	@Query("SELECT  a FROM Airport d WHERE d.airport_name=:airport_name")
	Airport retrieveByName(String airport_name);
	
	

}
