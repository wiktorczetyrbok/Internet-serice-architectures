package org.isa.service;

import org.isa.dto.city.GetCitizenDetailsResponse;
import org.isa.dto.city.GetCitizensResponse;
import org.isa.dto.city.PutCitizenRequest;

import java.util.UUID;

public interface CitizenService {
    void addCitizen(GetCitizenDetailsResponse getCitizenDetailsResponse);


    GetCitizensResponse getAllCitizens();

    void deleteCitizen(UUID id);

    GetCitizenDetailsResponse updateCitizen(UUID id, PutCitizenRequest putCitizenRequest);

    GetCitizenDetailsResponse getCitizenById(UUID uuid);
}
