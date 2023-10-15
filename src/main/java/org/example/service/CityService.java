package org.example.service;

import org.example.dto.CityDto;
import org.example.model.City;

import java.util.List;

public interface CityService {
    void addCity(City city);

    List<CityDto> getAllCities();
}
