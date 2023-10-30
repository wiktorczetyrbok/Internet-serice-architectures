package org.example.mapper;

import org.example.dto.CityDto;
import org.example.model.Citizen;
import org.example.model.City;

import java.util.List;

public class CityMapper {

    public static City mapToCity(CityDto cityDto, List<Citizen> citizenList) {
        return City.builder()
                .id(cityDto.getId())
                .area(cityDto.getArea())
                .name(cityDto.getName())
                .citizens(citizenList)
                .build();
    }

    public static CityDto mapToCityDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .area(city.getArea())
                .name(city.getName())
                .citizensID(city.getCitizens().stream().map(c -> c.getId()).toList())
                .build();
    }
}
