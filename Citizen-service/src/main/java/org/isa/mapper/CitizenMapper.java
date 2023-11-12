package org.isa.mapper;

import org.isa.dto.city.GetCitizenCityNameResponse;
import org.isa.dto.city.GetCitizenResponse;
import org.isa.dto.city.GetCitizensResponse;
import org.isa.model.Citizen;
import org.isa.model.City;

import java.util.List;

public class CitizenMapper {
    public static GetCitizenResponse mapToCitizenDto(Citizen citizen) {

        return GetCitizenResponse.builder()
                .cityId(citizen.getCity().getId())
                .id(citizen.getId())
                .name(citizen.getName())
                .age(citizen.getAge())
                .build();
    }

    public static GetCitizenCityNameResponse mapToGetCitizenDto(Citizen citizen) {
        return GetCitizenCityNameResponse.builder()
                .cityName(citizen.getCity().getName())
                .id(citizen.getId())
                .name(citizen.getName())
                .age(citizen.getAge())
                .build();
    }

    public static Citizen mapToCitizen(GetCitizenResponse getCitizenResponse, City city) {
        return Citizen.builder()
                .id(getCitizenResponse.getId())
                .city(city)
                .name(getCitizenResponse.getName())
                .age(getCitizenResponse.getAge())
                .build();
    }

    public static GetCitizensResponse mapToGetCitizensResponse(List<Citizen> citizens) {
        return GetCitizensResponse.builder()
                .citizens(citizens.stream()
                        .map(CitizenMapper::mapToCitizenDto)
                        .toList())
                .build();
    }
}
