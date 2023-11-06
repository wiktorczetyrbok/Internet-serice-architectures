package org.isa.service;

import org.isa.dto.CitizenDto;
import org.isa.dto.GetCitizenDto;

import java.util.List;
import java.util.UUID;

public interface CitizenService {
    void addCitizen(CitizenDto citizenDto);


    List<GetCitizenDto> getAllCitizens();

    boolean deleteCitizen(UUID id);

    GetCitizenDto getCitizenByName(String name);

    CitizenDto updateCitizen(UUID id, CitizenDto updatedCitizenDto);
}
