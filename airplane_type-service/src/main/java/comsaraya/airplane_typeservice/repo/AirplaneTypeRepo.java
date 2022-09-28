package comsaraya.airplane_typeservice.repo;

import comsaraya.airplane_typeservice.model.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneTypeRepo extends JpaRepository<AirplaneType, Long> {
}
