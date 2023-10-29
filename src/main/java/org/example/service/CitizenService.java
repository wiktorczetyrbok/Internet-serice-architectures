package org.example.service;

import org.example.dto.CitizenDto;
import org.example.model.Citizen;

import java.util.List;

public interface CitizenService {
    void addCitizen(CitizenDto citizenDto);

    void addCitizen(Citizen citizen);

    List<CitizenDto> getAllCitizens();

    void deleteCitizen(Citizen selectedCitizen);
}
