package org.isa.service.impl;


import org.isa.dto.CityDto;
import org.isa.exception.CityNotFoundException;
import org.isa.mapper.CityMapper;
import org.isa.model.City;
import org.isa.repository.CityRepository;
import org.isa.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void addCity(CityDto cityDto) {
        City city = CityMapper.mapToCity(cityDto);
        cityRepository.save(city);
    }

    @Override
    public boolean deleteCity(UUID id) {
        City city = cityRepository.findById(id).orElse(null);
        if (city == null) {
            return false;
        }
        cityRepository.delete(city);
        return true;
    }

    @Override
    public CityDto updateCity(UUID id, CityDto updatedCityDto) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found: " + id));
        city.setName(updatedCityDto.getName());

        cityRepository.save(city);

        return CityMapper.mapToCityDto(city);
    }

    @Override
    public List<CityDto> getAllCities() {
        return cityRepository.findAll().stream().map(CityMapper::mapToCityDto).toList();
    }
}
