package com.saraya.rentalsservice.mapper;

import com.saraya.rentalsservice.bean.Rentals;
import com.saraya.rentalsservice.dto.RentalsDto;

public class RentalsMapper {
    public Rentals toEntity(RentalsDto dto) {
        Rentals rentals = new Rentals();
        rentals.setName(dto.getName());
        rentals.setCarNo(dto.getCarNo());
        rentals.setAmount(dto.getAmount());
        return rentals;
    }

}
