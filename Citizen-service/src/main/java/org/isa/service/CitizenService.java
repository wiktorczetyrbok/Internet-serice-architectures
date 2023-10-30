package org.isa.service;

import org.isa.dto.CitizenDto;

import java.util.List;
import java.util.UUID;

public interface CitizenService {
    void addCitizen(CitizenDto citizenDto);


    List<CitizenDto> getAllCitizens();

    boolean deleteCitizen(UUID id);

    CitizenDto getCitizenByName(String name);

    CitizenDto updateCitizen(UUID id, CitizenDto updatedCitizenDto);
}
