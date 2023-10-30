package org.isa.mapper;

import org.isa.dto.CitizenDto;
import org.isa.model.Citizen;

public class CitizenMapper {
    public static CitizenDto mapToCitizenDto(Citizen citizen) {

        return CitizenDto.builder()
                .cityId(citizen.getCityId())
                .id(citizen.getId())
                .name(citizen.getName())
                .age(citizen.getAge())
                .build();
    }

    public static Citizen mapToCitizen(CitizenDto citizenDto) {
        return Citizen.builder()
                .id(citizenDto.getId())
                .cityId(citizenDto.getCityId())
                .name(citizenDto.getName())
                .age(citizenDto.getAge())
                .build();
    }
}
