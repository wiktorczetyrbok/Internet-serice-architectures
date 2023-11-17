package org.isa.service;

import org.isa.dto.city.GetCitizenCityNameResponse;
import org.isa.dto.city.GetCitizenResponse;
import org.isa.dto.city.GetCitizensResponse;
import org.isa.dto.city.PutCitizenRequest;

import java.util.UUID;

public interface CitizenService {
    void addCitizen(GetCitizenResponse getCitizenResponse);


    GetCitizensResponse getAllCitizens();

    void deleteCitizen(UUID id);

    GetCitizenResponse updateCitizen(UUID id, PutCitizenRequest putCitizenRequest);

    GetCitizenCityNameResponse getCitizenById(UUID uuid);
}
