package org.isa.mapper;

import org.isa.dto.city.GetCitizenDetailsResponse;
import org.isa.dto.city.GetCitizenResponse;
import org.isa.dto.city.GetCitizensResponse;
import org.isa.dto.city.PutCitizenRequest;
import org.isa.model.Citizen;
import org.isa.model.City;

import java.util.List;
import java.util.UUID;

public class CitizenMapper {
    public static GetCitizenResponse mapToGetCitizenResponse(Citizen citizen) {

        return GetCitizenResponse.builder()
                .city(CityMapper.mapToGetCityResponse(citizen.getCity()))
                .id(citizen.getId())
                .name(citizen.getName())
                .build();
    }

    public static GetCitizenDetailsResponse mapToGetCitizenDetailsResponse(Citizen citizen) {

        return GetCitizenDetailsResponse.builder()
                .city(CityMapper.mapToGetCityResponse(citizen.getCity()))
                .id(citizen.getId())
                .name(citizen.getName())
                .age(citizen.getAge())
                .build();
    }

    public static Citizen mapToCitizen(GetCitizenDetailsResponse getCitizenResponse, City city) {
        return Citizen.builder()
                .id(getCitizenResponse.getId())
                .city(city)
                .name(getCitizenResponse.getName())
                .age(getCitizenResponse.getAge())
                .build();
    }

    public static Citizen mapToCitizen(PutCitizenRequest putCitizenRequest, City city, UUID uuid) {
        return Citizen.builder()
                .id(uuid)
                .city(city)
                .name(putCitizenRequest.getName())
                .age(putCitizenRequest.getAge())
                .build();
    }

    public static GetCitizensResponse mapToGetCitizensResponse(List<Citizen> citizens) {
        return GetCitizensResponse.builder()
                .citizens(citizens.stream()
                        .map(CitizenMapper::mapToGetCitizenResponse)
                        .toList())
                .build();
    }
}
