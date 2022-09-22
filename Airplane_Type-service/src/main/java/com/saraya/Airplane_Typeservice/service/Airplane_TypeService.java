package com.saraya.Airplane_Typeservice.service;

import com.saraya.Airplane_Typeservice.model.Airplane_Type;
import com.saraya.Airplane_Typeservice.repository.Airplane_TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class Airplane_TypeService {

    private final Airplane_TypeRepository repository;

    public List<Airplane_Type> getAllAirplane_Types() {
        return repository.findAll();
    }

    public Airplane_Type getAirplane_Type(Long airplane_type_id) {
        return repository.findById(airplane_type_id).orElse(new Airplane_Type());
    }

    public Airplane_Type saveAirplane_Type(Airplane_Type airplane_type) {
        return repository.save(airplane_type);
    }

    public Airplane_Type updateAirplane_Type(Airplane_Type airplane_type) {
        return repository.save(airplane_type);
    }

    public void deleteAirplane_Type(Long airplane_type_id) {
         repository.deleteById(airplane_type_id);
    }
}
