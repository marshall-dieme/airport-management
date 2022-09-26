package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Airport_Geo;
@Repository

public interface AirportgeoRepo extends JpaRepository<Airport_Geo, Long> {
	@Query("SELECT  g FROM Airport_Geo d WHERE g.airport_geo=:airport_geo")

	
	Airport_Geo findById(long airport_geo_id);
}
