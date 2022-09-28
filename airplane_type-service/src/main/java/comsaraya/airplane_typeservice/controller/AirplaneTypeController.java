package comsaraya.airplane_typeservice.controller;

import comsaraya.airplane_typeservice.model.AirplaneType;
import comsaraya.airplane_typeservice.service.AirplaneTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airplaneType")
public class AirplaneTypeController {

    @Autowired
    private final AirplaneTypeService service;

    public AirplaneTypeController(AirplaneTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<AirplaneType> getAllAirplaneType(){
        return service.save();
    }
    @GetMapping("/{id}")
    public Optional<AirplaneType> findAirportTypeById(@PathVariable("id") Long airplane_type_id){
        return service.findById(airplane_type_id);
    }
    @PostMapping("/")
    public AirplaneType saveAirplaneType(@RequestBody AirplaneType airplaneType){
        return service.saveAirplaneType(airplaneType);
    }
    @PutMapping("/")
    public AirplaneType updateAiplaneType(@RequestBody AirplaneType airplaneType){
        return service.update(airplaneType);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long airplane_type_id){
        service.delete(airplane_type_id);
    }
}
