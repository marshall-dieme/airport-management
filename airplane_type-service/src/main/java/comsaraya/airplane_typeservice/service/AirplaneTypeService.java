package comsaraya.airplane_typeservice.service;

import comsaraya.airplane_typeservice.model.AirplaneType;
import comsaraya.airplane_typeservice.repo.AirplaneTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneTypeService {

    @Autowired
    private final AirplaneTypeRepo repo;

    public AirplaneTypeService(AirplaneTypeRepo repo) {
        this.repo = repo;
    }

    public List<AirplaneType> save() {

        return repo.findAll();
    }

    public Optional<AirplaneType> findById(Long airplane_type_id) {
        return repo.findById(airplane_type_id);
    }

    public AirplaneType saveAirplaneType(AirplaneType airplaneType) {
        return repo.save(airplaneType);
    }

    public AirplaneType update(AirplaneType airplaneType) {
        return repo.save(airplaneType);
    }

    public void delete(Long airplane_type_id) {
        repo.deleteById(airplane_type_id);
    }
}
