package org.example.service;

import org.example.dto.CityDto;

import java.util.List;

public interface CityService {
    void addCity(CityDto cityDto);

    List<CityDto> getAllCities();

    CityDto getCityByName(String cityName);

    boolean deleteCity(String name);
}
