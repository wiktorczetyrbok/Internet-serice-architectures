package org.example.service.impl;

import org.example.dto.CitizenDto;
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

    public CitizenServiceImpl(CityRepository cityRepository,
                              CitizenRepository citizenRepository) {
        this.cityRepository = cityRepository;
        this.citizenRepository = citizenRepository;
    }

    @Override
    public void addCitizen(CitizenDto citizenDto) {
        City city;
        try {
            city = cityRepository.findByName(citizenDto.getCityName()).orElseThrow(SQLException::new);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Citizen citizen = CitizenMapper.mapToCitizen(citizenDto, city);
        citizenRepository.save(citizen);

    }


    @Override
    public List<CitizenDto> getAllCitizens() {
        List<Citizen> citizens = citizenRepository.findAll();

        List<CitizenDto> collect = citizens.stream()
                .map(CitizenMapper::mapToCitizenDto)
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public boolean deleteCitizen(String name) {
        try {
            Citizen citizen = citizenRepository.findByName(name).orElseThrow();
            citizenRepository.delete(citizen);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Override
    public CitizenDto getCitizenByName(String name) {
        Citizen citizen = citizenRepository.findByName(name).orElseThrow();
        return CitizenMapper.mapToCitizenDto(citizen);
    }

}
