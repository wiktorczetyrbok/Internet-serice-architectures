package org.isa.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.isa.dto.city.GetCitizenDetailsResponse;
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
    public void addCitizen(GetCitizenDetailsResponse getCitizenDetailsResponse) {
        City city = cityRepository.findById(getCitizenDetailsResponse.getCity().getId())
                .orElseThrow(() -> new CityNotFoundException("City not found: " + getCitizenDetailsResponse.getCity().getId()));
        Citizen citizen = CitizenMapper.mapToCitizen(getCitizenDetailsResponse, city);
        citizenRepository.save(citizen);
    }

    @Override
    public GetCitizensResponse getAllCitizens() {
        List<Citizen> citizens = citizenRepository.findAll();
        return CitizenMapper.mapToGetCitizensResponse(citizens);
    }

    @Override
    public void deleteCitizen(UUID id) {
        Citizen citizen = citizenRepository.findById(id)
                .orElseThrow(() -> new CitizenNotFoundException("Citizen not found: " + id));
        citizenRepository.delete(citizen);
    }

    @Override
    public GetCitizenDetailsResponse updateCitizen(UUID id, PutCitizenRequest putCitizenRequest) {
        Citizen existingCitizen = citizenRepository.findById(id)
                .orElseThrow(() -> new CitizenNotFoundException("Citizen not found: " + id));
        existingCitizen.setName(putCitizenRequest.getName());
        existingCitizen.setAge(putCitizenRequest.getAge());

        citizenRepository.save(existingCitizen);

        return CitizenMapper.mapToGetCitizenDetailsResponse(existingCitizen);
    }

    @Override
    public GetCitizenDetailsResponse getCitizenById(UUID uuid) {
        Citizen citizen = citizenRepository.findById(uuid)
                .orElseThrow(() -> new CitizenNotFoundException("Citizen not found: " + uuid));
        return CitizenMapper.mapToGetCitizenDetailsResponse(citizen);
    }

    @Override
    public GetCitizensResponse getCitizenByCity(UUID id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found: " + id));


        return CitizenMapper.mapToGetCitizensResponse(city.getCitizens());
    }
}




