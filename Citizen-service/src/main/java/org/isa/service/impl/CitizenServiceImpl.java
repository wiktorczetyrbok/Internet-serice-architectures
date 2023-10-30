package org.isa.service.impl;

import org.isa.dto.CitizenDto;
import org.isa.exception.CitizenNotFoundException;
import org.isa.mapper.CitizenMapper;
import org.isa.model.Citizen;
import org.isa.repository.CitizenRepository;
import org.isa.service.CitizenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CitizenServiceImpl implements CitizenService {
    private final CitizenRepository citizenRepository;

    public CitizenServiceImpl(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    @Override
    public void addCitizen(CitizenDto citizenDto) {
//        City city = cityRepository.findById(citizenDto.getCityId())
//                .orElseThrow(() -> new CityNotFoundException("City not found: " + citizenDto.getCityId()));
        Citizen citizen = CitizenMapper.mapToCitizen(citizenDto);
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
    public boolean deleteCitizen(UUID id) {
        Citizen citizen = citizenRepository.findById(id).orElse(null);
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

    @Override
    public CitizenDto updateCitizen(UUID id, CitizenDto updatedCitizenDto) {
        Citizen existingCitizen = citizenRepository.findById(id)
                .orElseThrow(() -> new CitizenNotFoundException("Citizen not found: " + id));
        existingCitizen.setName(updatedCitizenDto.getName());
        existingCitizen.setAge(updatedCitizenDto.getAge());
      /*  City city = cityRepository
                .findById(updatedCitizenDto.getCityId())
                .orElseThrow(() -> new CityNotFoundException("City not found: " + id));
        existingCitizen.setCity(city);*/

        citizenRepository.save(existingCitizen);

        return CitizenMapper.mapToCitizenDto(existingCitizen);
    }
}




