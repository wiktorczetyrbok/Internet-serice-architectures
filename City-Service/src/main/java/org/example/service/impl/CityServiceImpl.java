package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.GetCitiesResponse;
import org.example.dto.GetCityResponse;
import org.example.dto.PutCityRequest;
import org.example.exception.CityNotFoundException;
import org.example.mapper.CityMapper;
import org.example.model.City;
import org.example.repository.CityRepository;
import org.example.repository.CityRestRepository;
import org.example.service.CityService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityRestRepository cityRestRepository;

    @Override
    public void addCity(GetCityResponse getCityResponse) {
        City city = CityMapper.mapToCity(getCityResponse);
        cityRestRepository.addCity(getCityResponse);
        cityRepository.save(city);
    }

    @Override
    public GetCitiesResponse getAllCities() {
        return CityMapper.mapToGetCitiesResponse(cityRepository.findAll());
    }

    @Override
    public GetCityResponse getCityByName(String cityName) {
        City city = cityRepository.getCityByName(cityName);
        if (city == null) {
            throw new CityNotFoundException("City not found: " + cityName);
        }
        return CityMapper.mapToGetCityResponse(city);
    }

    @Override
    public boolean deleteCity(UUID id) {
        City city = cityRepository.findById(id).orElse(null);
        if (city == null) {
            return false;
        }
        cityRestRepository.delete(id);
        cityRepository.delete(city);
        return true;
    }

    @Override
    public GetCityResponse updateCity(UUID id, PutCityRequest putCityRequest) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found: " + id));

        city.setName(putCityRequest.getName());
        if (!city.getName().equalsIgnoreCase(putCityRequest.getName())) {
            cityRestRepository.updateName(id, putCityRequest);
        }
        city.setArea(putCityRequest.getArea());

        cityRepository.save(city);

        return CityMapper.mapToGetCityResponse(city);
    }

}
