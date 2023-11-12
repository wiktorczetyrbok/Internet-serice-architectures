package org.example.service;

import org.example.dto.GetCityResponse;
import org.example.dto.PutCityRequest;

import java.util.List;
import java.util.UUID;

public interface CityService {
    void addCity(GetCityResponse getCityResponse);

    List<GetCityResponse> getAllCities();

    GetCityResponse getCityByName(String cityName);

    boolean deleteCity(UUID id);

    GetCityResponse updateCity(UUID id, PutCityRequest putCityRequest);
}
