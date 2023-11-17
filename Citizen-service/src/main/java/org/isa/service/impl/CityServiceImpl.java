package org.isa.service.impl;


import lombok.RequiredArgsConstructor;
import org.isa.dto.citizen.GetCityResponse;
import org.isa.dto.citizen.PutCityRequest;
import org.isa.exception.CityNotFoundException;
import org.isa.mapper.CityMapper;
import org.isa.model.City;
import org.isa.repository.CityRepository;
import org.isa.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public void addCity(GetCityResponse getCityResponse) {
        City city = CityMapper.mapToCity(getCityResponse);
        cityRepository.save(city);
    }

    @Override
    public void deleteCity(UUID id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found: " + id));
        cityRepository.delete(city);
    }

    @Override
    public GetCityResponse updateCity(UUID id, PutCityRequest putCityRequest) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found: " + id));
        city.setName(putCityRequest.getName());

        cityRepository.save(city);

        return CityMapper.mapToGetCityResponse(city);
    }

    @Override
    public List<GetCityResponse> getAllCities() {
        return cityRepository.findAll().stream().map(CityMapper::mapToGetCityResponse).toList();
    }

    @Override
    public GetCityResponse getCityById(UUID id) {
        return CityMapper.mapToGetCityResponse(cityRepository
                .findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found: " + id)));
    }
}
