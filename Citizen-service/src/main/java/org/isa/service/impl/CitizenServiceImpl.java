package org.isa.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.isa.dto.city.GetCitizenCityNameResponse;
import org.isa.dto.city.GetCitizenResponse;
import org.isa.dto.city.GetCitizensResponse;
import org.isa.dto.city.PutCitizenRequest;
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

@Slf4j
@Service
@RequiredArgsConstructor
public class CitizenServiceImpl implements CitizenService {
    private final CitizenRepository citizenRepository;
    private final CityRepository cityRepository;

    @Override
    public void addCitizen(GetCitizenResponse getCitizenResponse) {
        City city = cityRepository.findById(getCitizenResponse.getCityId())
                .orElseThrow(() -> new CityNotFoundException("City not found: " + getCitizenResponse.getCityId()));
        Citizen citizen = CitizenMapper.mapToCitizen(getCitizenResponse, city);
        citizenRepository.save(citizen);
    }

    @Override
    public GetCitizensResponse getAllCitizens() {
        List<Citizen> citizens = citizenRepository.findAll();
        return CitizenMapper.mapToGetCitizensResponse(citizens);
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
    public GetCitizenResponse updateCitizen(UUID id, PutCitizenRequest putCitizenRequest) {
        Citizen existingCitizen = citizenRepository.findById(id)
                .orElseThrow(() -> new CitizenNotFoundException("Citizen not found: " + id));
        existingCitizen.setName(putCitizenRequest.getName());
        existingCitizen.setAge(putCitizenRequest.getAge());

        citizenRepository.save(existingCitizen);

        return CitizenMapper.mapToCitizenDto(existingCitizen);
    }

    @Override
    public GetCitizenCityNameResponse getCitizenById(UUID uuid) {
        Citizen citizen = citizenRepository.findById(uuid)
                .orElseThrow(() -> new CitizenNotFoundException("Citizen not found: " + uuid));
        return CitizenMapper.mapToGetCitizenDto(citizen);
    }
}




