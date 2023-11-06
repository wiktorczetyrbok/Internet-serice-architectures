package org.isa.service;


import org.isa.dto.CityDto;

import java.util.List;
import java.util.UUID;

public interface CityService {
    void addCity(CityDto cityDto);

    boolean deleteCity(UUID id);

    CityDto updateCity(UUID id, CityDto updatedCityDto);

    List<CityDto> getAllCities();

    CityDto getCityById(UUID id);
}
