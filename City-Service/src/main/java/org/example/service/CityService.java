package org.example.service;

import org.example.dto.CityDto;

import java.util.List;
import java.util.UUID;

public interface CityService {
    void addCity(CityDto cityDto);

    List<CityDto> getAllCities();

    CityDto getCityByName(String cityName);

    boolean deleteCity(UUID id);

    CityDto updateCity(UUID id, CityDto updatedCityDto);
}
