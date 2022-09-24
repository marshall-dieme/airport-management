package com.saraya.airplane_type.service;

import com.saraya.airplane_type.model.Airplane_type;
import com.saraya.airplane_type.repository.Airplane_typeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class Airplane_typeService {
    private final Airplane_typeRepo repository;

    public List<Airplane_type> getAllAirplane_Types() {
        return repository.findAll();
    }

    public Airplane_type getAirplane_Type(Long airplane_type_id) {
        return repository.findById(airplane_type_id).orElse(new Airplane_type());
    }

    public Airplane_type saveAirplane_type(Airplane_type airplane_type) {
        return repository.save(airplane_type);
    }

    public Airplane_type updateAirplane_type(Airplane_type airplane_type) {
        return repository.save(airplane_type);
    }

    public void deleteAirplane_type(Long airplane_type_id) {
        repository.deleteById(airplane_type_id);
    }
}
