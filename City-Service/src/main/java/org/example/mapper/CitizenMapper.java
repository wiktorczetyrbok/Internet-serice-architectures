package org.example.mapper;

import org.example.dto.CitizenDto;
import org.example.model.Citizen;
import org.example.model.City;

public class CitizenMapper {
    public static CitizenDto mapToCitizenDto(Citizen citizen) {

        return CitizenDto.builder()
                .cityId(citizen.getCity().getId())
                .id(citizen.getId())
                .name(citizen.getName())
                .age(citizen.getAge())
                .build();
    }

    public static Citizen mapToCitizen(CitizenDto citizenDto, City city) {
        return Citizen.builder()
                .id(citizenDto.getId())
                .city(city)
                .name(citizenDto.getName())
                .age(citizenDto.getAge())
                .build();
    }
}