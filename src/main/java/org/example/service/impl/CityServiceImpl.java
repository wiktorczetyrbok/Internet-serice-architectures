package org.example.service.impl;

import org.example.dto.CityDto;
import org.example.mapper.CityMapper;
import org.example.model.Citizen;
import org.example.model.City;
import org.example.repository.CitizenRepository;
import org.example.repository.CityRepository;
import org.example.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
        System.out.println(cityRepository.findAll());
        return cityRepository
                .findAll()
                .stream()
                .map(CityMapper::mapToCityDto)
                .collect(Collectors.toList());
    }

    @Override
    public CityDto getCityByName(String cityName) {
        return CityMapper.mapToCityDto(cityRepository.getCityByName(cityName));
    }

    @Override
    public boolean deleteCity(String name) {
        try {
            City city = cityRepository.findByName(name).orElseThrow();
            cityRepository.delete(city);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    private List<Citizen> findCitizensById(List<UUID> uuids) {
        return uuids.stream().map(c -> citizenRepository
                        .findById(c)
                        .orElseThrow())
                .toList();
    }

}
