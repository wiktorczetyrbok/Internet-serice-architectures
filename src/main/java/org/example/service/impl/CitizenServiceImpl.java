package org.example.service.impl;

import org.example.dto.CitizenDto;
import org.example.exception.CitizenNotFoundException;
import org.example.exception.CityNotFoundException;
import org.example.mapper.CitizenMapper;
import org.example.model.Citizen;
import org.example.model.City;
import org.example.repository.CitizenRepository;
import org.example.repository.CityRepository;
import org.example.service.CitizenService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CitizenServiceImpl implements CitizenService {
    private final CityRepository cityRepository;
    private final CitizenRepository citizenRepository;

    public CitizenServiceImpl(CityRepository cityRepository, CitizenRepository citizenRepository) {
        this.cityRepository = cityRepository;
        this.citizenRepository = citizenRepository;
    }

    @Override
    public void addCitizen(CitizenDto citizenDto) {
        City city = cityRepository.findByName(citizenDto.getCityName())
                .orElseThrow(() -> new CityNotFoundException("City not found: " + citizenDto.getCityName()));
        Citizen citizen = CitizenMapper.mapToCitizen(citizenDto, city);
        citizenRepository.save(citizen);
    }

    @Override
    public List<CitizenDto> getAllCitizens() {
        List<Citizen> citizens = citizenRepository.findAll();
        return citizens.stream()
                .map(CitizenMapper::mapToCitizenDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteCitizen(String name) {
        Citizen citizen = citizenRepository.findByName(name).orElse(null);
        if (citizen == null) {
            return false;
        }
        citizenRepository.delete(citizen);
        return true;
    }

    @Override
    public CitizenDto getCitizenByName(String name) {
        Citizen citizen = citizenRepository.findByName(name)
                .orElseThrow(() -> new CitizenNotFoundException("Citizen not found: " + name));
        return CitizenMapper.mapToCitizenDto(citizen);
    }
}




