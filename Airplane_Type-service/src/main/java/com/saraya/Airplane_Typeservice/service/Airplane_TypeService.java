package com.saraya.Airplane_Typeservice.service;

import com.saraya.Airplane_Typeservice.consumer.AirplaneConsumer;
import com.saraya.Airplane_Typeservice.consumer.ResponseAirplaneAndAirplaneType;
import com.saraya.Airplane_Typeservice.model.Airplane_Type;
import com.saraya.Airplane_Typeservice.repository.Airplane_TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class Airplane_TypeService {

    private final Airplane_TypeRepository repository;

    private final AirplaneConsumer airplaneConsumer;



    public List<ResponseAirplaneAndAirplaneType> getAllAirplane_TypesWithPassengers() {
        List<ResponseAirplaneAndAirplaneType> responseAirplaneAndAirplaneTypes = new ArrayList<>();
        ResponseAirplaneAndAirplaneType responseAirplaneAndAirplaneType = new ResponseAirplaneAndAirplaneType();
        List<Airplane_Type> airplane_types = repository.findAll();
        for (Airplane_Type airplane_type : airplane_types) {
            responseAirplaneAndAirplaneType.setAirplane_type(airplane_type);
            responseAirplaneAndAirplaneType.setAirplane(airplaneConsumer.getAirplane(airplane_type.getAirplane_id()));
            responseAirplaneAndAirplaneTypes.add(responseAirplaneAndAirplaneType);
        }
        return responseAirplaneAndAirplaneTypes;
    }

    public List<Airplane_Type> getAllAirplane_Types() {
        return repository.findAll();
    }

    public ResponseAirplaneAndAirplaneType getAirplane_TypeWithPassenger(Long airplane_type_id) {
        ResponseAirplaneAndAirplaneType responseAirplaneAndAirplaneType = new ResponseAirplaneAndAirplaneType();
        responseAirplaneAndAirplaneType.setAirplane_type(repository.findById(airplane_type_id).orElse(null));
        responseAirplaneAndAirplaneType.setAirplane(airplaneConsumer.getAirplane(airplane_type_id));
        return responseAirplaneAndAirplaneType;
    }

    public Airplane_Type getAirplane_Type(Long airplane_type_id) {
        return repository.findById(airplane_type_id).orElse(null);
    }

    public Airplane_Type saveAirplane_Type(Airplane_Type airplane_type) {
        airplaneConsumer.getAirplane(airplane_type.getAirplane_id());
        return repository.save(airplane_type);
    }

    public Airplane_Type updateAirplane_Type(Airplane_Type airplane_type) {
        airplaneConsumer.getAirplane(airplane_type.getAirplane_id());
        return repository.save(airplane_type);
    }

    public void deleteAirplane_Type(Long airplane_type_id) {
         repository.deleteById(airplane_type_id);
    }
}
