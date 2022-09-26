package com.saraya.airplanetypeservice.service;

import com.saraya.airplanetypeservice.model.Type;
import com.saraya.airplanetypeservice.repos.TypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    private final TypeRepo repo;

    public TypeService(TypeRepo repo) {
        this.repo = repo;
    }



    public List<Type> getAll(){
        return repo.findAll();

    }



    public Long getTypeId(String airplaneTypeIdentifier ) {
        return repo.getTypeId(airplaneTypeIdentifier);
    }


    public Type create(Type type){
        return repo.save(type);
    }

    public Type update(Type type){
        return repo.save(type);
    }






    public void delete(Long id ){
        repo.deleteById(id);
    }
}