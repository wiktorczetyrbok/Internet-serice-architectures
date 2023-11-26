package org.isa.service;


import org.isa.dto.citizen.GetCityResponse;
import org.isa.dto.citizen.PutCityRequest;

import java.util.List;
import java.util.UUID;

public interface CityService {
    void addCity(GetCityResponse getCityResponse);

    void deleteCity(UUID id);

    GetCityResponse updateCity(UUID id, PutCityRequest putCityRequest);

    List<GetCityResponse> getAllCities();

    GetCityResponse getCityById(UUID id);
}
