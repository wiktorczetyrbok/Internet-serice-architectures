package org.example.mapper;

import org.example.dto.CityDto;
import org.example.model.City;

public class CityMapper {

    public static City mapToCity(CityDto cityDto) {
        return City.builder()
                .id(cityDto.getId())
                .area(cityDto.getArea())
                .name(cityDto.getName())
                .citizensIds(cityDto.getCitizensIds())
                .build();
    }

    public static CityDto mapToCityDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .area(city.getArea())
                .name(city.getName())
                .citizensIds(city.getCitizensIds())
                .build();
    }
}
