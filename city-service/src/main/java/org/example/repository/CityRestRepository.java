package org.example.repository;

import org.example.dto.GetCityResponse;
import org.example.dto.PutCityRequest;

import java.util.UUID;

public interface CityRestRepository {
    void delete(UUID id);

    void updateName(UUID id, PutCityRequest putCityRequest);

    void addCity(GetCityResponse getCityResponse);
}
