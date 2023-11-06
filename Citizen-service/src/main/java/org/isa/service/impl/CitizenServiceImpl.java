package org.isa.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.isa.dto.CitizenDto;
import org.isa.dto.GetCitizenDto;
import org.isa.exception.CitizenNotFoundException;
import org.isa.exception.CityNotFoundException;
import org.isa.mapper.CitizenMapper;
import org.isa.model.Citizen;
import org.isa.model.City;
import org.isa.repository.CitizenRepository;
import org.isa.repository.CityRepository;
import org.isa.service.CitizenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CitizenServiceImpl implements CitizenService {
    private final CitizenRepository citizenRepository;
    private final CityRepository cityRepository;

    public CitizenServiceImpl(CitizenRepository citizenRepository, CityRepository cityRepository) {
        this.citizenRepository = citizenRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public void addCitizen(CitizenDto citizenDto) {
        City city = cityRepository.findById(citizenDto.getCityId())
                .orElseThrow(() -> new CityNotFoundException("City not found: " + citizenDto.getCityId()));
        Citizen citizen = CitizenMapper.mapToCitizen(citizenDto, city);
        citizenRepository.save(citizen);
    }

    @Override
    public List<GetCitizenDto> getAllCitizens() {
        List<Citizen> citizens = citizenRepository.findAll();
        return citizens.stream()
                .map(CitizenMapper::mapToGetCitizenDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteCitizen(UUID id) {
        Citizen citizen = citizenRepository.findById(id).orElse(null);
        if (citizen == null) {
            return false;
        }
        citizenRepository.delete(citizen);
        return true;
    }

    @Override
    public GetCitizenDto getCitizenByName(String name) {
        Citizen citizen = citizenRepository.findByName(name)
                .orElseThrow(() -> new CitizenNotFoundException("Citizen not found: " + name));
        return CitizenMapper.mapToGetCitizenDto(citizen);
    }

    @Override
    public CitizenDto updateCitizen(UUID id, CitizenDto updatedCitizenDto) {
        Citizen existingCitizen = citizenRepository.findById(id)
                .orElseThrow(() -> new CitizenNotFoundException("Citizen not found: " + id));
        existingCitizen.setName(updatedCitizenDto.getName());
        existingCitizen.setAge(updatedCitizenDto.getAge());

        citizenRepository.save(existingCitizen);

        return CitizenMapper.mapToCitizenDto(existingCitizen);
    }
}




