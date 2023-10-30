package org.example.service;

import org.example.dto.CitizenDto;

import java.util.List;

public interface CitizenService {
    void addCitizen(CitizenDto citizenDto);


    List<CitizenDto> getAllCitizens();

    boolean deleteCitizen(String name);

    CitizenDto getCitizenByName(String name);

    CitizenDto updateCitizen(String name, CitizenDto updatedCitizenDto);
}
