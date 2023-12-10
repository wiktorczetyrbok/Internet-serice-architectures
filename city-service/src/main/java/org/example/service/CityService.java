package org.example.service;

import org.example.dto.GetCitiesResponse;
import org.example.dto.GetCityResponse;
import org.example.dto.PutCityRequest;

import java.util.UUID;

public interface CityService {
    void addCity(GetCityResponse getCityResponse);

    GetCitiesResponse getAllCities();

    GetCityResponse getCityById(UUID id);

    void deleteCity(UUID id);

    GetCityResponse updateCity(UUID id, PutCityRequest putCityRequest);
}
