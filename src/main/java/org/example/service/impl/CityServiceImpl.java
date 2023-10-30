package org.example.service.impl;

import org.example.dto.CityDto;
import org.example.exception.CityNotFoundException;
import org.example.mapper.CityMapper;
import org.example.model.Citizen;
import org.example.model.City;
import org.example.repository.CitizenRepository;
import org.example.repository.CityRepository;
import org.example.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CitizenRepository citizenRepository;


    public CityServiceImpl(CityRepository cityRepository, CitizenRepository citizenRepository) {
        this.cityRepository = cityRepository;
        this.citizenRepository = citizenRepository;
    }

    @Override
    public void addCity(CityDto cityDto) {
        City city = CityMapper.mapToCity(cityDto, findCitizensById(cityDto.getCitizensID()));
        cityRepository.save(city);
    }

    @Override
    public List<CityDto> getAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities.stream()
                .map(CityMapper::mapToCityDto)
                .collect(Collectors.toList());
    }

    @Override
    public CityDto getCityByName(String cityName) {
        City city = cityRepository.getCityByName(cityName);
        if (city == null) {
            throw new CityNotFoundException("City not found: " + cityName);
        }
        return CityMapper.mapToCityDto(city);
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
        city.setArea(updatedCityDto.getArea());
        cityRepository.save(city);

        return CityMapper.mapToCityDto(city);
    }

    private List<Citizen> findCitizensById(List<UUID> uuids) {
        return uuids.stream().map(c -> citizenRepository
                        .findById(c)
                        .orElseThrow())
                .toList();
    }

}
