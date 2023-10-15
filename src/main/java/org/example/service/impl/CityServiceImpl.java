package org.example.service.impl;

import org.example.dto.CityDto;
import org.example.mapper.CityMapper;
import org.example.model.City;
import org.example.repository.CityRepository;
import org.example.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void addCity(City city) {
        cityRepository.save(city);
    }


    @Override
    public List<CityDto> getAllCities() {
        System.out.println(cityRepository
                .findAll());
        return cityRepository
                .findAll()
                .stream()
                .map(CityMapper::mapToCityDto)
                .collect(Collectors.toList());
    }

}
